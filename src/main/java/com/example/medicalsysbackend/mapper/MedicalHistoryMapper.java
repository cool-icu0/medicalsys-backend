package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.MedicalHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【medical_history】的数据库操作Mapper
* @createDate 2024-04-22 22:00:16
* @Entity generator.domain.MedicalHistory
*/
public interface MedicalHistoryMapper extends BaseMapper<MedicalHistory> {
    @Select("select * from medical_history")
    public List<MedicalHistory> selectAllmedicalHistory();

    @Select("select * from medical_history where user_id = #{userId}")
    public List<MedicalHistory> selectMedicalHistoryByUserId(int userId);

    @Select("select * from medical_history where id = #{id}")
    public MedicalHistory selectMedicalHistoryById(int id);

    @Insert("INSERT INTO medical_history values(null, #{userId},#{medicalCondition},#{diagnosisDate},#{treatment},#{doctorName})")
    public int insertMedicalHistory(MedicalHistory medicalHistory);

    @Update("update medical_history set user_id = #{userId}, medical_condition = #{medicalCondition}, diagnosis_date = #{diagnosisDate}, treatment = #{treatment}, doctor_name = #{doctorName} where id = #{id}")
    public int updateMedicalHistory(MedicalHistory medicalHistory);
}




