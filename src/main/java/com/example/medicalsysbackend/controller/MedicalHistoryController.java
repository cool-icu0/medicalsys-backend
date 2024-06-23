package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.MedicalHistory;
import com.example.medicalsysbackend.domain.Reply;
import com.example.medicalsysbackend.service.MedicalHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/mediHistory")
public class MedicalHistoryController {
    @Resource
    MedicalHistoryService medicalHistoryService;

    @ApiOperation(value="查询所有人病史信息")
    @RequestMapping(value = "selectAllmedicalHistory",method = RequestMethod.GET)
    public ResponseResult selectAllmedicalHistory(){
        List<MedicalHistory> result= medicalHistoryService.selectAllmedicalHistory();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询所有人病史信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有查询所有人病史信息");
        }
    }

    @ApiOperation(value="根据用户名来查询用户的病史信息")
    @RequestMapping(value = "selectMedicalHistoryByUserId/{userid}",method = RequestMethod.GET)
    public ResponseResult selectMedicalHistoryByUserId(@PathVariable int userid){
        List<MedicalHistory> result= medicalHistoryService.selectMedicalHistoryByUserId(userid);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询用户的病史信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有用户的病史信息");
        }
    }

    @ApiOperation(value="添加病史")
    @RequestMapping(value = "insertMedicalHistory",method = RequestMethod.POST)
    public ResponseResult insertMedicalHistory(@RequestBody MedicalHistory medicalHistory) throws ParseException {
        int result=medicalHistoryService.insertMedicalHistory(medicalHistory);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"添加成功",result);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"添加失败",result);

    }

    @ApiOperation(value="修改病史信息")
    @RequestMapping(value = "updateMedicalHistory",method = RequestMethod.POST)
    public ResponseResult updateMedicalHistory(@RequestBody MedicalHistory medicalHistory){
        int result=medicalHistoryService.updateMedicalHistory(medicalHistory);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"修改病史成功",result);
        else{
            MedicalHistory medicalHistory1 = medicalHistoryService.selectMedicalHistoryById(medicalHistory.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"修改病史失败",medicalHistory1);
        }
    }

    @ApiOperation(value="分页显示病史")
    @GetMapping("/allWaterFreePager2")
    @CrossOrigin
    public Object allWaterFreePager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<MedicalHistory> list = medicalHistoryService.selectAllmedicalHistory();
        PageInfo<MedicalHistory> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询分页成功",pageInfo);
    }
}
