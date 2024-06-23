package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.Medicine;
import com.example.medicalsysbackend.domain.PatientTracking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【patient_tracking】的数据库操作Mapper
* @createDate 2024-04-22 22:00:22
* @Entity generator.domain.PatientTracking
*/
public interface PatientTrackingMapper extends BaseMapper<PatientTracking> {
    @Select("select * from patient_tracking")
    public List<PatientTracking> selectAllPatientTracking();

    @Select("select * from patient_tracking where user_id = #{userId}")
    public List<PatientTracking> selectPatientTrackingByUserId(int userId);

    @Select("select * from patient_tracking where id = #{id}")
    public PatientTracking selectPatientTrackingById(int id);

    @Select("select * from patient_tracking where datediff(NOW(),tracking_date) >= 7 and is_recovery = 0")
    public List<PatientTracking> selectPatientTrackingEndTerm();

    @Insert("insert into patient_tracking values(null,#{userId},#{trackingDate},#{isRecovery})")
    public int insertPatientTracking(PatientTracking patientTracking);

    @Update("update patient_tracking set user_id = #{userId},tracking_date=#{trackingDate},is_recovery=#{isRecovery} where id = #{id}")
    public int updatePatientTracking(PatientTracking patientTracking);
}




