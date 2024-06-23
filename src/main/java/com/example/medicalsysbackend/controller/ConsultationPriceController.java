package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.ConsultationPrice;
import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.example.medicalsysbackend.service.ConsultationPriceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/conPrice")
public class ConsultationPriceController {
    @Resource
    ConsultationPriceService consultationPriceService;

    @ApiOperation(value="查询所有价格信息")
    @RequestMapping(value = "selectAllConsultation_price",method = RequestMethod.GET)
    public ResponseResult selectAllConsultation_price(){
        List<ConsultationPrice> result= consultationPriceService.selectAllConsultation_price();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据职称来查询价格信息")
    @RequestMapping(value = "selectConsultationPriceByPosition/{position}",method = RequestMethod.GET)
    public ResponseResult selectConsultationPriceByPosition(@PathVariable String position){
        ConsultationPrice consultationPrice= consultationPriceService.selectConsultationPriceByPosition(position);
        System.out.println(consultationPrice);
        List<ConsultationPrice> result = new ArrayList<>();
        result.add(consultationPrice);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="添加问诊价格信息")
    @RequestMapping(value = "insertConsultationPrice",method = RequestMethod.POST)
    public ResponseResult insertConsultationPrice(@RequestBody ConsultationPrice consultationPrice) throws ParseException {
        int result=consultationPriceService.insertConsultationPrice(consultationPrice);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),consultationPrice);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),consultationPrice);

    }

    @ApiOperation(value="修改问诊价格信息")
    @RequestMapping(value = "updateConsultationPrice",method = RequestMethod.POST)
    public ResponseResult updateConsultationPrice(@RequestBody ConsultationPrice consultationPrice){
        int result=consultationPriceService.updateConsultationPrice(consultationPrice);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),consultationPrice);
        else{
            ConsultationPrice consultationRecord1 = consultationPriceService.selectConsultationPriceById(consultationPrice.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),consultationRecord1);
        }
    }

    @ApiOperation(value="分页显示问诊价格信息")
    @GetMapping("/allConsultationPricePager2")
    @CrossOrigin
    public Object allConsultationPricePager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<ConsultationPrice> list = consultationPriceService.selectAllConsultation_price();
        PageInfo<ConsultationPrice> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),pageInfo);
    }
}
