package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.Department;
import com.example.medicalsysbackend.domain.DoctorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【doctor_info】的数据库操作Mapper
* @createDate 2024-04-22 22:00:04
* @Entity generator.domain.DoctorInfo
*/
public interface DoctorInfoMapper extends BaseMapper<DoctorInfo> {
    @Select("select * from doctor_info")
    public List<DoctorInfo> selectAllDoctorInfo();

    @Select("select * from doctor_info where id = #{id}")
    public DoctorInfo selectDoctorInfoById(int id);

    @Select("select * from doctor_info where doctor_name LIKE concat('%',#{doctorName},'%') ")
    public List<DoctorInfo> selectDoctorInfoBydoctorName(String doctorName);

    @Select("select * from doctor_info where department = #{department}")
    public List<DoctorInfo> selectDoctorInfoByDepartment(String department);

    @Insert("INSERT INTO doctor_info values(null, #{doctorName},#{specialty},#{hospitalName},#{department},#{position},#{experienceYears},#{introduction},#{role},#{imgUrl},1)")
    public int insertDoctorInfo(DoctorInfo doctorInfo);

    @Update("update doctor_info set doctor_name = #{doctorName}, specialty = #{specialty}, specialty = #{specialty}, hospital_name = #{hospitalName}, department = #{department}, position = #{position}, experience_years = #{experienceYears}, introduction = #{introduction}, role = #{role}, img_url = #{imgUrl} where id = #{id}")
    public int updateDoctorInfo(DoctorInfo doctorInfo);

    @Update("update doctor_info set is_delete = 1 where id = #{id}")
    public int deleteDoctorInfo(int id);
}




