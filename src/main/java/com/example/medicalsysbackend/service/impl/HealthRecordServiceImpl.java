package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.mapper.HealthRecordMapper;
import com.example.medicalsysbackend.service.HealthRecordService;
import com.example.medicalsysbackend.domain.HealthRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Cool
* @description 针对表【health_record】的数据库操作Service实现
* @createDate 2024-04-22 22:00:12
*/
@Service
public class HealthRecordServiceImpl extends ServiceImpl<HealthRecordMapper, HealthRecord>
    implements HealthRecordService {
    @Resource
    HealthRecordMapper healthRecordMapper;

    @Override
    public List<HealthRecord> selectAllHealthRecord() {
        return healthRecordMapper.selectAllHealthRecord();
    }

    @Override
    public HealthRecord selectHealthRecordByUserId(int userId) {
        return healthRecordMapper.selectHealthRecordByUserId(userId);
    }

    @Override
    public HealthRecord selectHealthRecordById(int id) {
        return healthRecordMapper.selectHealthRecordById(id);
    }

    @Override
    public int insertHealthRecord(HealthRecord healthRecord) {
        HealthRecord healthRecord1 = healthRecordMapper.selectHealthRecordByUserId(healthRecord.getUserId());
        if(healthRecord1 != null) return -1;
        return healthRecordMapper.insertHealthRecord(healthRecord);
    }

    @Override
    public int updateHealthRecord(HealthRecord healthRecord) {
        return healthRecordMapper.updateHealthRecord(healthRecord);
    }

    @Override
    public List<HealthRecord> selectHealthRecordByUserName(String username) {

        return null;
    }
}




