package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.Department;
import com.example.medicalsysbackend.domain.DoctorInfo;
import com.example.medicalsysbackend.domain.Medicine;
import com.example.medicalsysbackend.service.DoctorInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.Doc;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/doctor")
public class DoctorInfoController {
    @Resource
    DoctorInfoService doctorInfoService;

    @ApiOperation(value="查询所有医生信息")
    @RequestMapping(value = "selectAllDoctorInfo",method = RequestMethod.GET)
    public ResponseResult selectAllDoctorInfo(){
        List<DoctorInfo> result= doctorInfoService.selectAllDoctorInfo();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询所有医生信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有医生信息");
        }
    }

    @ApiOperation(value="根据医生名来查询医生信息")
    @RequestMapping(value = "selectDepartmentByDepartmentName/{name}",method = RequestMethod.GET)
    public ResponseResult selectDepartmentByDepartmentName(@PathVariable String name){
        List<DoctorInfo> result= doctorInfoService.selectDoctorInfoBydoctorName(name);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有信息");
        }
    }

    @ApiOperation(value="根据科室名来查询医生信息")
    @RequestMapping(value = "selectDoctorInfoByDepartment/{department}",method = RequestMethod.GET)
    public ResponseResult selectDoctorInfoByDepartment(@PathVariable String department){
        List<DoctorInfo> result= doctorInfoService.selectDoctorInfoByDepartment(department);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有信息");
        }
    }

    @ApiOperation(value="添加医生信息")
    @RequestMapping(value = "insertDoctorInfo",method = RequestMethod.POST)
    public ResponseResult insertDoctorInfo(@RequestBody DoctorInfo doctorInfo){
        int result=doctorInfoService.insertDoctorInfo(doctorInfo);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"添加成功",doctorInfo);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"添加失败",doctorInfo);

    }

    @ApiOperation(value="修改医生信息")
    @RequestMapping(value = "updateDepartment",method = RequestMethod.POST)
    public ResponseResult updateDepartment(@RequestBody DoctorInfo doctorInfo){
        int result=doctorInfoService.updateDoctorInfo(doctorInfo);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"医生信息修改成功",doctorInfo);
        else{
            DoctorInfo doctorInfo1 = doctorInfoService.selectDoctorInfoById(doctorInfo.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"医生信息修改失败",doctorInfo1);
        }
    }

    @ApiOperation(value="删除医生信息")
    @RequestMapping(value = "deleteDoctorInfo/{id}",method = RequestMethod.POST)
    public ResponseResult deleteDoctorInfo(@PathVariable int id){
        int result=doctorInfoService.deleteDoctorInfo(id);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"医生信息删除成功",id);
        else{
            DoctorInfo doctorInfo1 = doctorInfoService.selectDoctorInfoById(id);
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"医生信息删除失败",doctorInfo1);
        }
    }

    @ApiOperation(value="分页显示科室信息")
    @GetMapping("/allDoctorInfoPager2")
    @CrossOrigin
    public Object allDoctorInfoPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<DoctorInfo> list = doctorInfoService.selectAllDoctorInfo();
        PageInfo<DoctorInfo> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询分页成功",pageInfo);
    }

    @ApiOperation(value="无密码支付，预约问诊")
    @RequestMapping(value = "bind",method = RequestMethod.POST)
    public ResponseResult bind(@RequestBody DoctorInfo doctorInfo, int user_id) throws ParseException {
        int result=doctorInfoService.charge(doctorInfo,user_id);
        if(result>=1){
            return  new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage());
        }else{
            return  new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage());
        }
    }
}
