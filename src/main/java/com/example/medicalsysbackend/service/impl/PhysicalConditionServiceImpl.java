package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.PhysicalCondition;
import com.example.medicalsysbackend.mapper.PhysicalConditionMapper;
import com.example.medicalsysbackend.service.PhysicalConditionService;
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
* @description 针对表【physical_condition】的数据库操作Service实现
* @createDate 2024-04-22 22:00:26
*/
@Service
public class PhysicalConditionServiceImpl extends ServiceImpl<PhysicalConditionMapper, PhysicalCondition>
    implements PhysicalConditionService{
    @Resource
    PhysicalConditionMapper physicalConditionMapper;

    @Override
    public List<PhysicalCondition> selectAllPhysicalCondition() {
        return physicalConditionMapper.selectAllPhysicalCondition();
    }

    @Override
    public PhysicalCondition selectPhysicalConditionByUserId(int userId) {
        return physicalConditionMapper.selectPhysicalConditionByUserId(userId);
    }

    @Override
    public PhysicalCondition selectPhysicalConditionById(int id) {
        return physicalConditionMapper.selectPhysicalConditionById(id);
    }

    @Override
    public int insertPhysicalCondition(PhysicalCondition physicalCondition) throws ParseException {
        PhysicalCondition physicalCondition1 = selectPhysicalConditionByUserId(physicalCondition.getUserId());
        if (physicalCondition1 != null) return -1;
        LocalDate date = LocalDate.now();
        DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(fullDate);
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(formattedDate);
        physicalCondition.setCheckupDate(d);
        return physicalConditionMapper.insertPhysicalCondition(physicalCondition);
    }

    @Override
    public int updatePhysicalCondition(PhysicalCondition physicalCondition) {
        return physicalConditionMapper.updatePhysicalCondition(physicalCondition);
    }
}




