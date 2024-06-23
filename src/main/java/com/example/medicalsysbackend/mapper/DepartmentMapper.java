package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.HealthRecord;
import com.example.medicalsysbackend.domain.Topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【department】的数据库操作Mapper
* @createDate 2024-04-22 21:59:59
* @Entity generator.domain.Department
*/
public interface DepartmentMapper extends BaseMapper<Department> {
    @Select("select * from department")
    public List<Department> selectAllDepartment();

    @Select("select * from department where id = #{id}")
    public Department selectDepartmentById(int id);

    @Select("select * from department where department_name LIKE concat('%',#{DepartmentName},'%') ")
    public List<Department> selectDepartmentByDepartmentName(String DepartmentName);

    @Insert("INSERT INTO department values(null, #{departmentName},#{description})")
    public int insertDepartment(Department department);

    @Update("update department set department_name = #{departmentName}, description = #{description} where id = #{id}")
    public int updateDepartment(Department department);
}




