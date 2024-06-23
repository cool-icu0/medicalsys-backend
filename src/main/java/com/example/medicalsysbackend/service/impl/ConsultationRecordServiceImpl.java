package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.service.ConsultationRecordService;
import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.example.medicalsysbackend.mapper.ConsultationRecordMapper;
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
* @description 针对表【consultation_record】的数据库操作Service实现
* @createDate 2024-04-22 21:59:54
*/
@Service
public class ConsultationRecordServiceImpl extends ServiceImpl<ConsultationRecordMapper, ConsultationRecord>
    implements ConsultationRecordService {
    @Resource
    ConsultationRecordMapper consultationRecordMapper;
    @Override
    public List<ConsultationRecord> selectAllConsultationRecord() {
        return consultationRecordMapper.selectAllConsultationRecord();
    }

    @Override
    public ConsultationRecord selectConsultationRecordById(int id) {
        return consultationRecordMapper.selectConsultationRecordById(id);
    }

    @Override
    public List<ConsultationRecord> selectConsultationRecordBydoctorId(int doctorId) {
        return consultationRecordMapper.selectConsultationRecordBydoctorId(doctorId);
    }

    @Override
    public int insertConsultationRecord(ConsultationRecord consultationRecord) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        consultationRecord.setEvaluationDate(d);
        return consultationRecordMapper.insertConsultationRecord(consultationRecord);
    }

    @Override
    public int defaultInsertConsultationRecord(int userId, int doctorId) throws ParseException {
        ConsultationRecord consultationRecord = new ConsultationRecord();
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        consultationRecord.setEvaluationDate(d);
        consultationRecord.setUserId(userId);
        consultationRecord.setDoctorId(doctorId);
        consultationRecord.setSatisfactionRating(5);
        return consultationRecordMapper.insertConsultationRecord(consultationRecord);
    }

    @Override
    public int updateConsultationRecord(ConsultationRecord consultationRecord) {
        return consultationRecordMapper.updateConsultationRecord(consultationRecord);
    }
}




