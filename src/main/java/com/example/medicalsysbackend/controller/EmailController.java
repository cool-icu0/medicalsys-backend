package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.PatientTracking;
import com.example.medicalsysbackend.domain.Prescription;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.mapper.UserMapper;
import com.example.medicalsysbackend.service.PatientTrackingService;
import com.example.medicalsysbackend.service.PrescriptionService;
import com.example.medicalsysbackend.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


@RestController
@RequestMapping(value="/api/v1/email")
public class EmailController {
    @Value("${spring.mail.username}")
    private String sendName;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    UserMapper userMapper;
    @Resource
    PrescriptionService prescriptionService;
    @Resource
    PatientTrackingService patientTrackingService;

    @ApiOperation(value="根据处方id受理用户的处方信息，并发送qq邮件给用户，用户表的邮箱必须正确")
    @RequestMapping(value = "send1",method = RequestMethod.GET)
    public ResponseResult sendMail01(int id){
        MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        Prescription prescription = prescriptionService.selectPrescriptionById(id);
        User user = userMapper.selectUserById(prescription.getUserId());
        try {
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(sendName);//发件人邮箱
            mMessageHelper.setTo(user.getEmail());//收件人邮箱
            mMessageHelper.setSubject("智慧医疗中心");//邮件的主题
            mMessageHelper.setText("尊敬的" + user.getUserAccount() + "用户" + "您的处方已被受理，请上网及时确认。");
            javaMailSender.send(mMessage);//发送邮件
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseResult(0, "邮件发送失败", null);
        }
        prescriptionService.authorize(prescription.getId());
        return new ResponseResult(0, "邮件发送成功", null);
    }

    @ApiOperation(value="根据病患追踪表id确认病患追踪信息，并发送qq邮件给用户，用户表的邮箱必须正确")
    @RequestMapping(value = "send2",method = RequestMethod.GET)
    public ResponseResult sendMail02(int id){
        MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        PatientTracking patientTracking = patientTrackingService.selectPatientTrackingById(id);
        User user = userMapper.selectUserById(patientTracking.getUserId());
        try {
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(sendName);//发件人邮箱
            mMessageHelper.setTo(user.getEmail());//收件人邮箱
            mMessageHelper.setSubject("智慧医疗中心");//邮件的主题
            mMessageHelper.setText("尊敬的" + user.getUserAccount() + "用户" + "，这次发消息给您主要是想了解一下您在"
            + patientTracking.getTrackingDate() + "问诊后情况如何，如果还有问题的话，请及时复诊，如果已经痊愈的话，麻烦您有空上网确认一下信息，谢谢配合！");
            javaMailSender.send(mMessage);//发送邮件
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseResult(0, "邮件发送失败", null);
        }
        return new ResponseResult(0, "邮件发送成功", null);
    }
}