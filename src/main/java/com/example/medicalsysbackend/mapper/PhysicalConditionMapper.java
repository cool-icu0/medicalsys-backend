package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.PatientTracking;
import com.example.medicalsysbackend.domain.PhysicalCondition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【physical_condition】的数据库操作Mapper
* @createDate 2024-04-22 22:00:26
* @Entity generator.domain.PhysicalCondition
*/
public interface PhysicalConditionMapper extends BaseMapper<PhysicalCondition> {
    @Select("select * from physical_condition")
    public List<PhysicalCondition> selectAllPhysicalCondition();

    @Select("select * from physical_condition where user_id = #{userId}")
    public PhysicalCondition selectPhysicalConditionByUserId(int userId);

    @Select("select * from physical_condition where id = #{id}")
    public PhysicalCondition selectPhysicalConditionById(int id);

    @Insert("insert into physical_condition values(null,#{userId},#{checkupDate},#{height},#{weight},#{bloodPressure},#{heartRate},#{bodyTemperature},#{symptoms},#{diagnosis})")
    public int insertPhysicalCondition(PhysicalCondition physicalCondition);

    @Update("update physical_condition set user_id = #{userId},checkup_date=#{checkupDate},height=#{height},weight=#{weight},blood_pressure=#{bloodPressure},heart_rate=#{heartRate},body_temperature=#{bodyTemperature},symptoms=#{symptoms},diagnosis=#{diagnosis} where id = #{id}")
    public int updatePhysicalCondition(PhysicalCondition physicalCondition);
}




