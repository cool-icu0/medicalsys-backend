package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.PhysicalCondition;
import com.example.medicalsysbackend.domain.Prescription;
import com.example.medicalsysbackend.service.PrescriptionService;
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
@RequestMapping(value = "/api/v1/prescription")
public class PrescriptionController {
    @Resource
    PrescriptionService prescriptionService;

    @ApiOperation(value="查询所有处方信息")
    @RequestMapping(value = "selectAllPrescription",method = RequestMethod.GET)
    public ResponseResult selectAllPrescription(){
        List<Prescription> result= prescriptionService.selectAllPrescription();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据用户id来查询处方信息")
    @RequestMapping(value = "selectPrescriptionByUserId/{userid}",method = RequestMethod.GET)
    public ResponseResult selectPrescriptionByUserId(@PathVariable int userid){
        List<Prescription> result= prescriptionService.selectPrescriptionByUserId(userid);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="添加处方信息")
    @RequestMapping(value = "insertPrescription",method = RequestMethod.POST)
    public ResponseResult insertPrescription(@RequestBody Prescription prescription) throws ParseException {
        int result=prescriptionService.insertPrescription(prescription);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),prescription);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),prescription);

    }

    @ApiOperation(value="医生添加处方信息（状态初始值为已受理）")
    @RequestMapping(value = "insertDocPrescription",method = RequestMethod.POST)
    public ResponseResult insertDocPrescription(@RequestBody Prescription prescription) throws ParseException {
        int result=prescriptionService.insertDocPrescription(prescription);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),prescription);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),prescription);

    }

    @ApiOperation(value="修改处方信息")
    @RequestMapping(value = "updatePrescription",method = RequestMethod.POST)
    public ResponseResult updatePrescription(@RequestBody Prescription prescription){
        int result=prescriptionService.updatePrescription(prescription);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),prescription);
        else{
            Prescription prescription1 = prescriptionService.selectPrescriptionById(prescription.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),prescription1);
        }
    }

    @ApiOperation(value="分页显示处方信息")
    @GetMapping("/allPrescriptionPager2")
    @CrossOrigin
    public Object allPrescriptionPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Prescription> list = prescriptionService.selectAllPrescription();
        PageInfo<Prescription> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),pageInfo);
    }

    @ApiOperation(value="药剂师拒绝处方或者是用户退款（用户操作的话，要在药剂师受理之前，如果已经受理了，则用户不能取消）")
    @RequestMapping(value = "unAuthorize",method = RequestMethod.GET)
    public ResponseResult unAuthorize(int id,int userid) throws ParseException {
        int result=prescriptionService.unAuthorize(id,userid);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage());
        else{
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage());
        }
    }

    @ApiOperation(value="医保卡支付")
    @RequestMapping(value = "healCardCharge",method = RequestMethod.GET)
    public ResponseResult healCardCharge(int id) throws ParseException {
        int result=prescriptionService.healCardCharge(id);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage());
        else if (result == -1){
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"余额不足");
        }else{
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage());
        }
    }
}
