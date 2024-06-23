package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.PhysicalCondition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【physical_condition】的数据库操作Service
* @createDate 2024-04-22 22:00:26
*/
public interface PhysicalConditionService extends IService<PhysicalCondition> {
    public List<PhysicalCondition> selectAllPhysicalCondition();
    public PhysicalCondition selectPhysicalConditionByUserId(int userId);
    public PhysicalCondition selectPhysicalConditionById(int id);
    public int insertPhysicalCondition(PhysicalCondition physicalCondition) throws ParseException;
    public int updatePhysicalCondition(PhysicalCondition physicalCondition);
}
