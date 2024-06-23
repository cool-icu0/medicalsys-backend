package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.HealthRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.MedicalHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【health_record】的数据库操作Mapper
* @createDate 2024-04-22 22:00:12
* @Entity generator.domain.HealthRecord
*/
public interface HealthRecordMapper extends BaseMapper<HealthRecord> {
    @Select("select * from health_record")
    public List<HealthRecord> selectAllHealthRecord();

    @Select("select * from health_record where user_id = #{userId}")
    public HealthRecord selectHealthRecordByUserId(int userId);

    @Select("select * from health_record where id = #{id}")
    public HealthRecord selectHealthRecordById(int id);

    @Insert("INSERT INTO health_record values(null, #{userId},#{basicInfo})")
    public int insertHealthRecord(HealthRecord healthRecord);

    @Update("update health_record set user_id = #{userId}, basic_info = #{basicInfo} where id = #{id}")
    public int updateHealthRecord(HealthRecord healthRecord);
}




