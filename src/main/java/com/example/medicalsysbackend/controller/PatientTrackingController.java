package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.ConsultationPrice;
import com.example.medicalsysbackend.domain.PatientTracking;
import com.example.medicalsysbackend.service.PatientTrackingService;
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
@RequestMapping(value = "/api/v1/patientTrack")
public class PatientTrackingController {
    @Resource
    PatientTrackingService patientTrackingService;

    @ApiOperation(value="查询所有病患追踪信息")
    @RequestMapping(value = "selectAllPatientTracking",method = RequestMethod.GET)
    public ResponseResult selectAllPatientTracking(){
        List<PatientTracking> result= patientTrackingService.selectAllPatientTracking();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据用户id来查询病患追踪信息")
    @RequestMapping(value = "selectPatientTrackingByUserId/{userid}",method = RequestMethod.GET)
    public ResponseResult selectPatientTrackingByUserId(@PathVariable int userid){
        List<PatientTracking> result= patientTrackingService.selectPatientTrackingByUserId(userid);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="添加病患追踪信息")
    @RequestMapping(value = "insertPatientTracking",method = RequestMethod.POST)
    public ResponseResult insertPatientTracking(@RequestBody PatientTracking patientTracking) throws ParseException {
        int result=patientTrackingService.insertPatientTracking(patientTracking);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),patientTracking);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),patientTracking);

    }

    @ApiOperation(value="修改病患追踪信息")
    @RequestMapping(value = "updatePatientTracking",method = RequestMethod.POST)
    public ResponseResult updatePatientTracking(@RequestBody PatientTracking patientTracking){
        int result=patientTrackingService.updatePatientTracking(patientTracking);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),patientTracking);
        else{
            PatientTracking patientTracking1 = patientTrackingService.selectPatientTrackingById(patientTracking.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),patientTracking1);
        }
    }

    @ApiOperation(value="分页显示病患追踪信息")
    @GetMapping("/allPatientTrackingPager2")
    @CrossOrigin
    public Object allPatientTrackingPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PatientTracking> list = patientTrackingService.selectAllPatientTracking();
        PageInfo<PatientTracking> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),pageInfo);
    }
}
