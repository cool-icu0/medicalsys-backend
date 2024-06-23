package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.HealthCard;
import com.example.medicalsysbackend.domain.Prescription;
import com.example.medicalsysbackend.mapper.HealthCardMapper;
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
@RequestMapping(value = "/api/v1/healCard")
public class HealthCardController {
    @Resource
    HealthCardMapper healthCardMapper;

    @ApiOperation(value="查询所有医保卡信息")
    @RequestMapping(value = "selectAllHealthCard",method = RequestMethod.GET)
    public ResponseResult selectAllHealthCard(){
        List<HealthCard> result= healthCardMapper.selectAllHealthCard();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据用户id来查询医保卡信息")
    @RequestMapping(value = "selectHealthCardByUserId/{userid}",method = RequestMethod.GET)
    public ResponseResult selectHealthCardByUserId(@PathVariable int userid){
        HealthCard healthCard= healthCardMapper.selectHealthCardByUserId(userid);
        System.out.println(healthCard);
        List<HealthCard> result = new ArrayList<>();
        result.add(healthCard);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据医保卡卡号来查询医保卡信息")
    @RequestMapping(value = "selectHealthCardByCardNumber/{cardNumber}",method = RequestMethod.GET)
    public ResponseResult selectHealthCardByUserId(@PathVariable String cardNumber){
        HealthCard healthCard= healthCardMapper.selectHealthCardByCardNumber(cardNumber);
        System.out.println(healthCard);
        List<HealthCard> result = new ArrayList<>();
        result.add(healthCard);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="添加医保卡信息")
    @RequestMapping(value = "insertHealthCard",method = RequestMethod.POST)
    public ResponseResult insertHealthCard(@RequestBody HealthCard healthCard) throws ParseException {
        int result=healthCardMapper.insertHealthCard(healthCard);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),healthCard);
        else if (result == -2)
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"改卡号已被绑定",healthCard);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),healthCard);

    }

    @ApiOperation(value="修改医保卡信息")
    @RequestMapping(value = "updateHealthCard",method = RequestMethod.POST)
    public ResponseResult updatePrescription(@RequestBody HealthCard healthCard){
        int result=healthCardMapper.updateHealthCard(healthCard);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),healthCard);
        else{
            HealthCard healthCard1 = healthCardMapper.selectHealthCardById(healthCard.getUserId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),healthCard1);
        }
    }

    @ApiOperation(value="分页显示医保卡信息")
    @GetMapping("/allHealthCardPager2")
    @CrossOrigin
    public Object allPrescriptionPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<HealthCard> list = healthCardMapper.selectAllHealthCard();
        PageInfo<HealthCard> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),pageInfo);
    }

}
