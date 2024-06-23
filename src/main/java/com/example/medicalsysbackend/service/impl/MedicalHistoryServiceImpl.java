package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.MedicalHistory;
import com.example.medicalsysbackend.mapper.MedicalHistoryMapper;
import com.example.medicalsysbackend.service.MedicalHistoryService;
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
* @description 针对表【medical_history】的数据库操作Service实现
* @createDate 2024-04-22 22:00:16
*/
@Service
public class MedicalHistoryServiceImpl extends ServiceImpl<MedicalHistoryMapper, MedicalHistory>
    implements MedicalHistoryService{

    @Resource
    MedicalHistoryMapper medicalHistoryMapper;

    @Override
    public List<MedicalHistory> selectAllmedicalHistory() {
        return medicalHistoryMapper.selectAllmedicalHistory();
    }

    @Override
    public List<MedicalHistory> selectMedicalHistoryByUserId(int userId) {
        return medicalHistoryMapper.selectMedicalHistoryByUserId(userId);
    }

    @Override
    public MedicalHistory selectMedicalHistoryById(int id) {
        return medicalHistoryMapper.selectMedicalHistoryById(id);
    }

    @Override
    public int insertMedicalHistory(MedicalHistory medicalHistory) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        medicalHistory.setDiagnosisDate(d);
        return medicalHistoryMapper.insertMedicalHistory(medicalHistory);
    }

    @Override
    public int updateMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryMapper.updateMedicalHistory(medicalHistory);
    }
}




