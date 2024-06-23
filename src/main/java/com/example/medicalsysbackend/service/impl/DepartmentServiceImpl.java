package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.Department;
import com.example.medicalsysbackend.mapper.DepartmentMapper;
import com.example.medicalsysbackend.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Cool
* @description 针对表【department】的数据库操作Service实现
* @createDate 2024-04-22 21:59:59
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{
    @Resource
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> selectAllDepartment() {
        return departmentMapper.selectAllDepartment();
    }

    @Override
    public Department selectDepartmentById(int id) {
        return departmentMapper.selectDepartmentById(id);
    }

    @Override
    public List<Department> selectDepartmentByDepartmentName(String departmentName) {
        return departmentMapper.selectDepartmentByDepartmentName(departmentName);
    }

    @Override
    public int insertDepartment(Department department) {
        List<Department> department1 = departmentMapper.selectDepartmentByDepartmentName(department.getDepartmentName());
        for(Department department2 : department1){
            if(department2 != null) return -1;
        }
        return departmentMapper.insertDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }
}




