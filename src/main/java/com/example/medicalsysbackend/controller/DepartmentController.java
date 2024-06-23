package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.Department;
import com.example.medicalsysbackend.domain.HealthRecord;
import com.example.medicalsysbackend.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/department")
public class DepartmentController {
    @Resource
    DepartmentService departmentService;

    @ApiOperation(value="查询所有科室信息")
    @RequestMapping(value = "selectAllDepartment",method = RequestMethod.GET)
    public ResponseResult selectAllDepartment(){
        List<Department> result= departmentService.selectAllDepartment();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询查询所有科室信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有科室信息");
        }
    }

    @ApiOperation(value="根据科室名来查询科室信息")
    @RequestMapping(value = "selectDepartmentByDepartmentName/{name}",method = RequestMethod.GET)
    public ResponseResult selectDepartmentByDepartmentName(@PathVariable String name){
        List<Department> result= departmentService.selectDepartmentByDepartmentName(name);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有信息");
        }
    }

    @ApiOperation(value="添加科室信息")
    @RequestMapping(value = "insertDepartment",method = RequestMethod.POST)
    public ResponseResult insertDepartment(@RequestBody Department department){
        int result=departmentService.insertDepartment(department);
        System.out.println(result+"--------3");
        if(result == -1) return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"该科室信息已存在",department.getDepartmentName());
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"添加成功",department);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"添加失败",department);

    }

    @ApiOperation(value="修改科室信息")
    @RequestMapping(value = "updateDepartment",method = RequestMethod.POST)
    public ResponseResult updateDepartment(@RequestBody Department department){
        int result=departmentService.updateDepartment(department);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"科室信息修改成功",department);
        else{
            Department department1 = departmentService.selectDepartmentById(department.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"科室信息修改失败",department1);
        }
    }

    @ApiOperation(value="分页显示科室信息")
    @GetMapping("/allDepartmentPager2")
    @CrossOrigin
    public Object allDepartmentPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Department> list = departmentService.selectAllDepartment();
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询分页成功",pageInfo);
    }
}
