package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.PatientTracking;
import com.example.medicalsysbackend.service.PatientTrackingService;
import com.example.medicalsysbackend.mapper.PatientTrackingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【patient_tracking】的数据库操作Service实现
* @createDate 2024-04-22 22:00:22
*/
@Service
public class PatientTrackingServiceImpl extends ServiceImpl<PatientTrackingMapper, PatientTracking>
    implements PatientTrackingService{
    @Resource
    PatientTrackingMapper patientTrackingMapper;

    @Override
    public List<PatientTracking> selectAllPatientTracking() {
        return patientTrackingMapper.selectAllPatientTracking();
    }

    @Override
    public List<PatientTracking> selectPatientTrackingByUserId(int userId) {
        return patientTrackingMapper.selectPatientTrackingByUserId(userId);
    }

    @Override
    public PatientTracking selectPatientTrackingById(int id) {
        return patientTrackingMapper.selectPatientTrackingById(id);
    }

    @Override
    public int insertPatientTracking(PatientTracking patientTracking) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        patientTracking.setTrackingDate(d);
        return patientTrackingMapper.insertPatientTracking(patientTracking);
    }

    @Override
    public int updatePatientTracking(PatientTracking patientTracking) {
        return patientTrackingMapper.updatePatientTracking(patientTracking);
    }

    @Override
    public List<PatientTracking> selectPatientTrackingEndTerm() {
        return patientTrackingMapper.selectPatientTrackingEndTerm();
    }
}




