package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.MedicalHistory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【medical_history】的数据库操作Service
* @createDate 2024-04-22 22:00:16
*/
public interface MedicalHistoryService extends IService<MedicalHistory> {
    public List<MedicalHistory> selectAllmedicalHistory();
    public List<MedicalHistory> selectMedicalHistoryByUserId(int userId);
    public MedicalHistory selectMedicalHistoryById(int id);
    public int insertMedicalHistory(MedicalHistory medicalHistory) throws ParseException;
    public int updateMedicalHistory(MedicalHistory medicalHistory);
}
