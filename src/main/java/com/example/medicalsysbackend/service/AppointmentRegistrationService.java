package com.example.medicalsysbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medicalsysbackend.domain.AppointmentRegistration;

import java.text.ParseException;
import java.util.List;


/**
* @author 24235
* @description 针对表【appointment_registration】的数据库操作Service
* @createDate 2024-05-11 22:26:47
*/
public interface AppointmentRegistrationService extends IService<AppointmentRegistration> {
    public List<AppointmentRegistration> selectAllAppointmentRegistration();
    public List<AppointmentRegistration> selectAppointmentRegistrationByUserId(int userId);
    public List<AppointmentRegistration> selectAppointmentRegistrationByDoctorId(int doctorId);
    public AppointmentRegistration selectAppointmentRegistrationById(int id);
    public int insertAppointmentRegistration(AppointmentRegistration appointmentRegistration) throws ParseException;
    public int updateAppointmentRegistration(AppointmentRegistration appointmentRegistration);
    public int authorize(AppointmentRegistration appointmentRegistration);
    public int unAuthorize(AppointmentRegistration appointmentRegistration);
}
