package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Cool
* @description 针对表【department】的数据库操作Service
* @createDate 2024-04-22 21:59:59
*/
public interface DepartmentService extends IService<Department> {
    public List<Department> selectAllDepartment();
    public Department selectDepartmentById(int id);
    public List<Department> selectDepartmentByDepartmentName(String DepartmentName);
    public int insertDepartment(Department department);
    public int updateDepartment(Department department);
}
