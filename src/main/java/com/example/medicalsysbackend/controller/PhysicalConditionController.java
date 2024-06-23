package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.PatientTracking;
import com.example.medicalsysbackend.domain.PhysicalCondition;
import com.example.medicalsysbackend.service.PhysicalConditionService;
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
@RequestMapping(value = "/api/v1/phyCondition")
public class PhysicalConditionController {
    @Resource
    PhysicalConditionService physicalConditionService;

    @ApiOperation(value="查询所有体检信息")
    @RequestMapping(value = "selectAllPhysicalCondition",method = RequestMethod.GET)
    public ResponseResult selectAllPhysicalCondition(){
        List<PhysicalCondition> result= physicalConditionService.selectAllPhysicalCondition();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据用户id来查询体检信息")
    @RequestMapping(value = "selectPhysicalConditionByUserId/{userid}",method = RequestMethod.GET)
    public ResponseResult selectPhysicalConditionByUserId(@PathVariable int userid){
        PhysicalCondition physicalCondition= physicalConditionService.selectPhysicalConditionByUserId(userid);
        System.out.println(physicalCondition);
        List<PhysicalCondition> result = new ArrayList<>();
        result.add(physicalCondition);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="添加体检信息")
    @RequestMapping(value = "insertPhysicalCondition",method = RequestMethod.POST)
    public ResponseResult insertPhysicalCondition(@RequestBody PhysicalCondition physicalCondition) throws ParseException {
        int result=physicalConditionService.insertPhysicalCondition(physicalCondition);
        System.out.println(result+"--------3");
        if (result == -1)
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),physicalCondition);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),physicalCondition);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),physicalCondition);

    }

    @ApiOperation(value="修改体检信息")
    @RequestMapping(value = "updatePhysicalCondition",method = RequestMethod.POST)
    public ResponseResult updatePhysicalCondition(@RequestBody PhysicalCondition physicalCondition){
        int result=physicalConditionService.updatePhysicalCondition(physicalCondition);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),physicalCondition);
        else{
            PhysicalCondition physicalCondition1 = physicalConditionService.selectPhysicalConditionById(physicalCondition.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),physicalCondition1);
        }
    }

    @ApiOperation(value="分页显示体检信息")
    @GetMapping("/allPhysicalConditionPager2")
    @CrossOrigin
    public Object allPhysicalConditionPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<PhysicalCondition> list = physicalConditionService.selectAllPhysicalCondition();
        PageInfo<PhysicalCondition> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),pageInfo);
    }
}
