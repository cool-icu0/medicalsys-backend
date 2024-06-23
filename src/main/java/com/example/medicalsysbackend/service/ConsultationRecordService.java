package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【consultation_record】的数据库操作Service
* @createDate 2024-04-22 21:59:54
*/
public interface ConsultationRecordService extends IService<ConsultationRecord> {
    public List<ConsultationRecord> selectAllConsultationRecord();
    public ConsultationRecord selectConsultationRecordById(int id);
    public List<ConsultationRecord> selectConsultationRecordBydoctorId(int doctorId);
    public int insertConsultationRecord(ConsultationRecord consultationRecord) throws ParseException;
    public int defaultInsertConsultationRecord(int userId, int doctorId) throws ParseException;
    public int updateConsultationRecord(ConsultationRecord consultationRecord);
}
