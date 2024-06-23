package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.Prescribeprice;
import com.example.medicalsysbackend.domain.Prescription;
import com.example.medicalsysbackend.service.PrescribepriceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/preprices")
public class PrescribepriceController {
    @Resource
    PrescribepriceService  prescribepriceService;

    @ApiOperation(value="查询所有处方价格信息")
    @RequestMapping(value = "selectAllPrescribeprice",method = RequestMethod.GET)
    public ResponseResult selectAllPrescribeprice(){
        List<Prescribeprice> result= prescribepriceService.selectAllPrescribeprice();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据处方id来查询处方信息")
    @RequestMapping(value = "selectPrescribepriceByPrescribeId/{pid}",method = RequestMethod.GET)
    public ResponseResult selectPrescribepriceByPrescribeId(@PathVariable int pid){
        Prescribeprice result= prescribepriceService.selectPrescribepriceByPrescribeId(pid);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }
}
