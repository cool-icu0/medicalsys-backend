package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.AppointmentRegistration;
import com.example.medicalsysbackend.domain.HealthCard;
import com.example.medicalsysbackend.mapper.AppointmentRegistrationMapper;
import com.example.medicalsysbackend.service.AppointmentRegistrationService;
import com.example.medicalsysbackend.service.HealthCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author 24235
* @description 针对表【appointment_registration】的数据库操作Service实现
* @createDate 2024-05-11 22:26:47
*/
@Service
public class AppointmentRegistrationServiceImpl extends ServiceImpl<AppointmentRegistrationMapper, AppointmentRegistration>
    implements AppointmentRegistrationService{
    @Resource
    AppointmentRegistrationMapper appointmentRegistrationMapper;
    @Resource
    HealthCardService healthCardService;

    @Override
    public List<AppointmentRegistration> selectAllAppointmentRegistration() {
        return appointmentRegistrationMapper.selectAllAppointmentRegistration();
    }

    @Override
    public List<AppointmentRegistration> selectAppointmentRegistrationByUserId(int userId) {
        return appointmentRegistrationMapper.selectAppointmentRegistrationByUserId(userId);
    }

    @Override
    public List<AppointmentRegistration> selectAppointmentRegistrationByDoctorId(int doctorId) {
        return appointmentRegistrationMapper.selectAppointmentRegistrationByDoctorId(doctorId);
    }

    @Override
    public AppointmentRegistration selectAppointmentRegistrationById(int id) {
        return selectAppointmentRegistrationById(id);
    }

    @Override
    public int insertAppointmentRegistration(AppointmentRegistration appointmentRegistration) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        appointmentRegistration.setAppointmentDate(d);
        return appointmentRegistrationMapper.insertAppointmentRegistration(appointmentRegistration);
    }

    @Override
    public int updateAppointmentRegistration(AppointmentRegistration appointmentRegistration) {
        return appointmentRegistrationMapper.updateAppointmentRegistration(appointmentRegistration);
    }

    @Override
    public int authorize(AppointmentRegistration appointmentRegistration) {
        appointmentRegistration.setIsComplete(1);
        return appointmentRegistrationMapper.updateAppointmentRegistration(appointmentRegistration);
    }

    @Override
    public int unAuthorize(AppointmentRegistration appointmentRegistration) {
        appointmentRegistration.setIsComplete(2);
        //将余额返回到医保卡里面
        HealthCard healthCard = healthCardService.selectHealthCardByUserId(appointmentRegistration.getUserId());
        healthCard.setCardPrices(appointmentRegistration.getAppPrices()+healthCard.getCardPrices());
        healthCardService.updateHealthCard(healthCard);
        return appointmentRegistrationMapper.updateAppointmentRegistration(appointmentRegistration);
    }
}




