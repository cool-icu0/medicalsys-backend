package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.example.medicalsysbackend.domain.UserDoctor;
import com.example.medicalsysbackend.service.UserDoctorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/uad")
public class UserDoctorController {
    @Resource
    UserDoctorService userDoctorService;

    @ApiOperation(value="根据医生id来查询用户id")
    @RequestMapping(value = "selectUserDoctorByDocId/{did}",method = RequestMethod.GET)
    public ResponseResult selectUserDoctorByDocId(@PathVariable int did){
        UserDoctor result= userDoctorService.selectUserDoctorByDocId(did);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据用户id来查询医生id")
    @RequestMapping(value = "selectUserDoctorByUserId/{uid}",method = RequestMethod.GET)
    public ResponseResult selectUserDoctorByUserId(@PathVariable int uid){
        UserDoctor result= userDoctorService.selectUserDoctorByUserId(uid);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }
}
