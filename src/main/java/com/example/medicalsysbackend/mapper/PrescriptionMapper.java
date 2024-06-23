package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.AppointmentRegistration;
import com.example.medicalsysbackend.domain.PhysicalCondition;
import com.example.medicalsysbackend.domain.Prescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【prescription】的数据库操作Mapper
* @createDate 2024-04-22 22:00:29
* @Entity generator.domain.Prescription
*/
public interface PrescriptionMapper extends BaseMapper<Prescription> {
    @Select("select * from prescription")
    public List<Prescription> selectAllPrescription();

    @Select("select * from prescription where user_id = #{userId}")
    public List<Prescription> selectPrescriptionByUserId(int userId);

    @Select("SELECT * from prescription where user_id = #{userId} ORDER BY id DESC limit 1")
    public Prescription selectOnlyOnePrescriptionByUserId(int userId);

    @Select("select * from prescription where id = #{id}")
    public Prescription selectPrescriptionById(int id);

    @Insert("insert into prescription values(null,#{userId},#{medicationGuide},#{createTime},#{status})")
    public int insertPrescription(Prescription prescription);

    @Update("update prescription set user_id = #{userId},medication_guide=#{medicationGuide},create_time=#{createTime} where id = #{id}")
    public int updatePrescription(Prescription prescription);

    @Update("update prescription set status='已受理' where id=#{id}")
    public int authorize(int id);

    @Update("update prescription set status=#{status} where id=#{id}")
    public int unAuthorize(int id,String status);
}




