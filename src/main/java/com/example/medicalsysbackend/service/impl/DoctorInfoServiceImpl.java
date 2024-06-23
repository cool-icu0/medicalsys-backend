package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.AppointmentRegistration;
import com.example.medicalsysbackend.domain.ConsultationPrice;
import com.example.medicalsysbackend.mapper.DoctorInfoMapper;
import com.example.medicalsysbackend.domain.DoctorInfo;
import com.example.medicalsysbackend.service.AppointmentRegistrationService;
import com.example.medicalsysbackend.service.ConsultationPriceService;
import com.example.medicalsysbackend.service.DoctorInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【doctor_info】的数据库操作Service实现
* @createDate 2024-04-22 22:00:04
*/
@Service
public class DoctorInfoServiceImpl extends ServiceImpl<DoctorInfoMapper, DoctorInfo>
    implements DoctorInfoService{
    @Resource
    DoctorInfoMapper doctorInfoMapper;
    @Resource
    AppointmentRegistrationService appointmentRegistrationService;
    @Resource
    ConsultationPriceService consultationPriceService;

    @Override
    public List<DoctorInfo> selectAllDoctorInfo() {
        return doctorInfoMapper.selectAllDoctorInfo();
    }

    @Override
    public DoctorInfo selectDoctorInfoById(int id) {
        return doctorInfoMapper.selectDoctorInfoById(id);
    }

    @Override
    public List<DoctorInfo> selectDoctorInfoBydoctorName(String doctorName) {
        return doctorInfoMapper.selectDoctorInfoBydoctorName(doctorName);
    }

    @Override
    public List<DoctorInfo> selectDoctorInfoByDepartment(String department) {
        return doctorInfoMapper.selectDoctorInfoByDepartment(department);
    }

    @Override
    public int insertDoctorInfo(DoctorInfo doctorInfo) {
        return doctorInfoMapper.insertDoctorInfo(doctorInfo);
    }

    @Override
    public int updateDoctorInfo(DoctorInfo doctorInfo) {
        return doctorInfoMapper.updateDoctorInfo(doctorInfo);
    }

    @Override
    public int deleteDoctorInfo(int id) {
        return doctorInfoMapper.deleteDoctorInfo(id);
    }

    @Override
    public int charge(DoctorInfo doctorInfo, int user_id) throws ParseException {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        AppointmentRegistration appointmentRegistration = new AppointmentRegistration();
        appointmentRegistration.setUserId(user_id);
        appointmentRegistration.setHospitalDepartment(doctorInfo.getDepartment());
        appointmentRegistration.setAppointmentDate(d);
        ConsultationPrice consultationPrice = consultationPriceService.selectConsultationPriceByPosition(doctorInfo.getPosition());
        appointmentRegistration.setAppPrices(consultationPrice.getPrice());
        appointmentRegistration.setDoctorId(doctorInfo.getId());
        return appointmentRegistrationService.insertAppointmentRegistration(appointmentRegistration);
    }
}




