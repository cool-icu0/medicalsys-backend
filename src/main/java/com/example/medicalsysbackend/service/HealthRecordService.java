package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.HealthRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Cool
* @description 针对表【health_record】的数据库操作Service
* @createDate 2024-04-22 22:00:12
*/
public interface HealthRecordService extends IService<HealthRecord> {
    public List<HealthRecord> selectAllHealthRecord();
    public HealthRecord selectHealthRecordByUserId(int userId);
    public HealthRecord selectHealthRecordById(int id);
    public int insertHealthRecord(HealthRecord healthRecord);
    public int updateHealthRecord(HealthRecord healthRecord);
    public List<HealthRecord> selectHealthRecordByUserName(String username);
}
