package com.example.medicalsysbackend.job;

import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.PatientTracking;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.service.PatientTrackingService;
import com.example.medicalsysbackend.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Configuration
@EnableScheduling
public class MyJobHandler {

    @Value("${spring.mail.username}")
    private String sendName;
    @Resource
    private JavaMailSender javaMailSender;
    @Resource
    PatientTrackingService patientTrackingService;
    @Resource
    UserService userService;

//    @Scheduled(cron = "0/5 * * * * ?")
    public void reportCurrentByCron(){
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }

    @Scheduled(cron = "0 00 8 * * ?")
    public void sum1() {
        List<PatientTracking> parkingrents = patientTrackingService.selectAllPatientTracking();
        int result=0;
        for(PatientTracking p : parkingrents){
            if (p.getIsRecovery() == 0){
                sendMail01(p);
                result++;
            }
        }
        System.out.println("当前时间：" + new Date());
        System.out.println("用药提醒："+result+"条记录");
    }

    @Scheduled(cron = "0 00 12 * * ?")
    public void sum2() {
        List<PatientTracking> parkingrents = patientTrackingService.selectAllPatientTracking();
        int result=0;
        for(PatientTracking p : parkingrents){
            if (p.getIsRecovery() == 0){
                sendMail01(p);
                result++;
            }
        }
        System.out.println("当前时间：" + new Date());
        System.out.println("用药提醒："+result+"条记录");
    }

    @Scheduled(cron = "0 00 20 * * ?")
    public void sum3() {
        List<PatientTracking> parkingrents = patientTrackingService.selectAllPatientTracking();
        int result=0;
        for(PatientTracking p : parkingrents){
            if (p.getIsRecovery() == 0){
                sendMail01(p);
                result++;
            }
        }
        System.out.println("当前时间：" + new Date());
        System.out.println("用药提醒："+result+"条记录");
    }

    @Scheduled(cron = "0 21 0 * * ?")
    public void sum4() {
        List<PatientTracking> patientTrackings = patientTrackingService.selectPatientTrackingEndTerm();
        int result=0;
        for(PatientTracking p : patientTrackings){
            sendMail02(p);
            result++;
        }
        System.out.println("当前时间：" + new Date());
        System.out.println("病患跟踪："+result+"条记录");
    }

    public ResponseResult sendMail01(PatientTracking patientTracking){
        System.out.println("当前时间：" + new Date());
        MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        User user = userService.selectUserById(patientTracking.getUserId());
        try {
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(sendName);//发件人邮箱
            mMessageHelper.setTo(user.getEmail());//收件人邮箱
            mMessageHelper.setSubject("智慧医疗中心");//邮件的主题
            mMessageHelper.setText("尊敬的" + user.getUserAccount() + "用户" + "，温馨提醒您，请及时用药！");
            javaMailSender.send(mMessage);//发送邮件
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseResult(0, "邮件发送失败", null);
        }
        return new ResponseResult(0, "邮件发送成功", null);
    }

    public ResponseResult sendMail02(PatientTracking patientTracking){
        System.out.println("当前时间：" + new Date());
        MimeMessage mMessage=javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        User user = userService.selectUserById(patientTracking.getUserId());
        try {
            mMessageHelper=new MimeMessageHelper(mMessage,true);
            mMessageHelper.setFrom(sendName);//发件人邮箱
            mMessageHelper.setTo(user.getEmail());//收件人邮箱
            mMessageHelper.setSubject("智慧医疗中心");//邮件的主题
            mMessageHelper.setText("尊敬的" + user.getUserAccount() + "用户" + "，距离您上次问诊已经过7天，请问您的病症是否痊愈，如果未痊愈的话，请回复未痊愈，如果痊愈的话，请回复已痊愈；如未回复，则默认为已经痊愈");
            javaMailSender.send(mMessage);//发送邮件
        } catch (MessagingException e) {
            e.printStackTrace();
            return new ResponseResult(0, "邮件发送失败", null);
        }
        return new ResponseResult(0, "邮件发送成功", null);
    }
}