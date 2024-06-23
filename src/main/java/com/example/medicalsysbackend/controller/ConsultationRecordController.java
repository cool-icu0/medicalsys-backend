package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.example.medicalsysbackend.domain.Department;
import com.example.medicalsysbackend.service.ConsultationRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/conRecord")
public class ConsultationRecordController {
    @Resource
    ConsultationRecordService consultationRecordService;

    @ApiOperation(value="查询所有问诊评价信息")
    @RequestMapping(value = "selectAllConsultationRecord",method = RequestMethod.GET)
    public ResponseResult selectAllConsultationRecord(){
        List<ConsultationRecord> result= consultationRecordService.selectAllConsultationRecord();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据医生id来查询问诊评价信息")
    @RequestMapping(value = "selectConsultationRecordBydoctorId/{doctorid}",method = RequestMethod.GET)
    public ResponseResult selectConsultationRecordBydoctorId(@PathVariable int doctorid){
        List<ConsultationRecord> result= consultationRecordService.selectConsultationRecordBydoctorId(doctorid);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="添加问诊评价信息")
    @RequestMapping(value = "insertConsultationRecord",method = RequestMethod.POST)
    public ResponseResult insertConsultationRecord(@RequestBody ConsultationRecord consultationRecord) throws ParseException {
        int result=consultationRecordService.insertConsultationRecord(consultationRecord);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),consultationRecord);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),consultationRecord);

    }

    @ApiOperation(value="如果用户未评价，添加默认问诊评价信息")
    @RequestMapping(value = "defaultInsertConsultationRecord",method = RequestMethod.POST)
    public ResponseResult defaultInsertConsultationRecord(int userId, int doctorId) throws ParseException {
        int result=consultationRecordService.defaultInsertConsultationRecord(userId,doctorId);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage());
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage());

    }

    @ApiOperation(value="修改问诊评价信息")
    @RequestMapping(value = "updateConsultationRecord",method = RequestMethod.POST)
    public ResponseResult updateConsultationRecord(@RequestBody ConsultationRecord consultationRecord){
        int result=consultationRecordService.updateConsultationRecord(consultationRecord);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),consultationRecord);
        else{
            ConsultationRecord consultationRecord1 = consultationRecordService.selectConsultationRecordById(consultationRecord.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),consultationRecord1);
        }
    }

    @ApiOperation(value="分页显示问诊评价信息")
    @GetMapping("/allDepartmentPager2")
    @CrossOrigin
    public Object allConsultationRecordPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ConsultationRecord> list = consultationRecordService.selectAllConsultationRecord();
        PageInfo<ConsultationRecord> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),pageInfo);
    }
}
