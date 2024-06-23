package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.AppointmentRegistration;
import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.example.medicalsysbackend.service.AppointmentRegistrationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@Api(tags = "预约登记表")
@CrossOrigin
@RequestMapping(value = "/api/v1/appoint")
public class AppointmentRegistrationController {
    @Resource
    AppointmentRegistrationService appointmentRegistrationService;

    @ApiOperation(value="查询所有预约的信息")
    @RequestMapping(value = "selectAllAppointmentRegistration",method = RequestMethod.GET)
    public ResponseResult selectAllAppointmentRegistration(){
        List<AppointmentRegistration> result= appointmentRegistrationService.selectAllAppointmentRegistration();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据医生id来查询预约信息")
    @RequestMapping(value = "selectAppointmentRegistrationByDoctorId/{doctorid}",method = RequestMethod.GET)
    public ResponseResult selectAppointmentRegistrationByDoctorId(@PathVariable int doctorid){
        List<AppointmentRegistration> result= appointmentRegistrationService.selectAppointmentRegistrationByDoctorId(doctorid);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="根据用户id来查询预约信息")
    @RequestMapping(value = "selectAppointmentRegistrationByUserId/{userid}",method = RequestMethod.GET)
    public ResponseResult selectAppointmentRegistrationByUserId(@PathVariable int userid){
        List<AppointmentRegistration> result= appointmentRegistrationService.selectAppointmentRegistrationByUserId(userid);
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),ErrorCode.NOT_FOUND_ERROR.getMessage());
        }
    }

    @ApiOperation(value="添加预约信息")
    @RequestMapping(value = "insertAppointmentRegistration",method = RequestMethod.POST)
    public ResponseResult insertAppointmentRegistration(@RequestBody AppointmentRegistration appointmentRegistration) throws ParseException {
        int result=appointmentRegistrationService.insertAppointmentRegistration(appointmentRegistration);
        System.out.println(result+"--------3");
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),appointmentRegistration);
        else
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),appointmentRegistration);

    }

    @ApiOperation(value="修改预约信息")
    @RequestMapping(value = "updateAppointmentRegistration",method = RequestMethod.POST)
    public ResponseResult updateAppointmentRegistration(@RequestBody AppointmentRegistration appointmentRegistration){
        int result=appointmentRegistrationService.updateAppointmentRegistration(appointmentRegistration);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),appointmentRegistration);
        else{
            AppointmentRegistration appointmentRegistration1 = appointmentRegistrationService.selectAppointmentRegistrationById(appointmentRegistration.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),appointmentRegistration1);
        }
    }

    @ApiOperation(value="医生受理预约信息")
    @RequestMapping(value = "authorize",method = RequestMethod.POST)
    public ResponseResult authorize(@RequestBody AppointmentRegistration appointmentRegistration){
        int result=appointmentRegistrationService.authorize(appointmentRegistration);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),appointmentRegistration);
        else{
            AppointmentRegistration appointmentRegistration1 = appointmentRegistrationService.selectAppointmentRegistrationById(appointmentRegistration.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),appointmentRegistration1);
        }
    }

    @ApiOperation(value="用户取消预约信息")
    @RequestMapping(value = "unAuthorize",method = RequestMethod.POST)
    public ResponseResult unAuthorize(@RequestBody AppointmentRegistration appointmentRegistration){
        int result=appointmentRegistrationService.unAuthorize(appointmentRegistration);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),appointmentRegistration);
        else{
            AppointmentRegistration appointmentRegistration1 = appointmentRegistrationService.selectAppointmentRegistrationById(appointmentRegistration.getId());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage(),appointmentRegistration1);
        }
    }

    @ApiOperation(value="分页显示预约信息")
    @GetMapping("/allAppointmentRegistrationPager2")
    @CrossOrigin
    public Object allAppointmentRegistrationPager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<AppointmentRegistration> list = appointmentRegistrationService.selectAllAppointmentRegistration();
        PageInfo<AppointmentRegistration> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage(),pageInfo);
    }
}
