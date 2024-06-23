package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.PatientTracking;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【patient_tracking】的数据库操作Service
* @createDate 2024-04-22 22:00:22
*/
public interface PatientTrackingService extends IService<PatientTracking> {
    public List<PatientTracking> selectAllPatientTracking();
    public List<PatientTracking> selectPatientTrackingByUserId(int userId);
    public PatientTracking selectPatientTrackingById(int id);
    public int insertPatientTracking(PatientTracking patientTracking) throws ParseException;
    public int updatePatientTracking(PatientTracking patientTracking);
    public List<PatientTracking> selectPatientTrackingEndTerm();
}
