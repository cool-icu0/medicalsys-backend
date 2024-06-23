package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.HealthRecord;
import com.example.medicalsysbackend.domain.MedicalHistory;
import com.example.medicalsysbackend.domain.Topic;
import com.example.medicalsysbackend.service.HealthRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@ApiOperation(value="过敏史")
@RequestMapping(value = "/api/v1/healrecord")
public class HealthRecordController {
    @Resource
    HealthRecordService healthRecordService;

    @ApiOperation(value="查询所有患者的过敏信息")
    @RequestMapping(value = "selectAllHealthRecord",method = RequestMethod.GET)
    public ResponseResult selectAllHealthRecord(){
        List<HealthRecord> result= healthRecordService.selectAllHealthRecord();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询所有患者的过敏成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有所有患者的过敏信息");
        }
    }

    @ApiOperation(value="根据用户ID来查询话过敏史")
    @RequestMapping(value = "HealthRecord/{useid}",method = RequestMethod.GET)
    public ResponseResult HealthRecord(@PathVariable int useid){
        HealthRecord healthRecord= healthRecordService.selectHealthRecordByUserId(useid);
        System.out.println(healthRecord);
        List<HealthRecord> result = new ArrayList<>();
        result.add(healthRecord);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有信息");
        }
    }

    @ApiOperation(value="添加新用户的过敏史，一个用户只有一条过敏史记录")
    @RequestMapping(value = "insertHealthRecord",method = RequestMethod.POST)
    public ResponseResult insertHealthRecord(@RequestBody HealthRecord healthRecord){
        int result=healthRecordService.insertHealthRecord(healthRecord);
        if(result == -1) return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"该用户的过敏史已存在",healthRecord.getUserId());
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"添加成功",healthRecord);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"添加失败",healthRecord);

    }

    @ApiOperation(value="修改过敏史")
    @RequestMapping(value = "updateHealthRecord",method = RequestMethod.POST)
    public ResponseResult updateHealthRecord(@RequestBody HealthRecord healthRecord){
        int result=healthRecordService.updateHealthRecord(healthRecord);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"过敏史信息修改成功",healthRecord);
        else{
            HealthRecord healthRecord1 = healthRecordService.selectHealthRecordById(healthRecord.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"过敏史信息修改失败",healthRecord1);
        }
    }

    @ApiOperation(value="分页显示过敏史")
    @GetMapping("/allHealthRecordPager2")
    @CrossOrigin
    public Object allTopicPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<HealthRecord> list = healthRecordService.selectAllHealthRecord();
        PageInfo<HealthRecord> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询分页成功",pageInfo);
    }
}
