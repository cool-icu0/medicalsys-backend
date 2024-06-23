package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【consultation_record】的数据库操作Mapper
* @createDate 2024-04-22 21:59:54
* @Entity generator.domain.ConsultationRecord
*/
public interface ConsultationRecordMapper extends BaseMapper<ConsultationRecord> {
    @Select("select * from consultation_record")
    public List<ConsultationRecord> selectAllConsultationRecord();

    @Select("select * from consultation_record where id = #{id}")
    public ConsultationRecord selectConsultationRecordById(int id);

    @Select("select * from consultation_record where doctor_id = #{doctorId}")
    public List<ConsultationRecord> selectConsultationRecordBydoctorId(int doctorId);

    @Insert("insert into consultation_record VALUES(null,#{evaluationDate},#{userId},#{doctorId},#{satisfactionRating},#{advice})")
    public int insertConsultationRecord(ConsultationRecord consultationRecord);

    @Update("update consultation_record set evaluation_date = #{evaluationDate}, user_id = #{userId}, doctor_id = #{doctorId}, satisfaction_rating = #{satisfactionRating}, advice = #{advice} where id = #{id}")
    public int updateConsultationRecord(ConsultationRecord consultationRecord);
}




