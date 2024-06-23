package com.example.medicalsysbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.AppointmentRegistration;
import com.example.medicalsysbackend.domain.ConsultationPrice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author 24235
* @description 针对表【appointment_registration】的数据库操作Mapper
* @createDate 2024-05-11 22:26:47
* @Entity generator.domain.AppointmentRegistration
*/
public interface AppointmentRegistrationMapper extends BaseMapper<AppointmentRegistration> {
    @Select("select * from appointment_registration")
    public List<AppointmentRegistration> selectAllAppointmentRegistration();

    @Select("select * from appointment_registration where user_id = #{userId}")
    public List<AppointmentRegistration> selectAppointmentRegistrationByUserId(int userId);

    @Select("select * from appointment_registration where doctor_id = #{doctorId}")
    public List<AppointmentRegistration> selectAppointmentRegistrationByDoctorId(int doctorId);

    @Select("select * from appointment_registration where id = #{id}")
    public AppointmentRegistration selectAppointmentRegistrationById(int id);

    @Insert("INSERT INTO appointment_registration values(null, #{userId},#{hospitalDepartment},#{doctorId},#{appointmentDate},#{appPrices},0)")
    public int insertAppointmentRegistration(AppointmentRegistration appointmentRegistration);

    @Update("update appointment_registration set user_id = #{userId}, hospital_department = #{hospitalDepartment}, doctor_id = #{doctorId}, appointment_date = #{appointmentDate}, app_prices = #{appPrices}, is_complete = #{isComplete} where id = #{id}")
    public int updateAppointmentRegistration(AppointmentRegistration appointmentRegistration);

}




