package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.Medicine;
import com.example.medicalsysbackend.service.MedicineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/medicine")
public class MedicineController {
    @Resource
    MedicineService medicineService;

    //查询所有药品信息
    @RequestMapping(value = "selectAllMedicine",method = RequestMethod.GET)
    public ResponseResult selectAllMedicine(){
        List<Medicine> result= medicineService.selectAllMedicine();
        System.out.println(result);
        if(result!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询所有药品成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有药品信息");
        }
    }

    //根据药品名来查询药品信息
    @RequestMapping(value = "selectMedicineByName/{name}",method = RequestMethod.GET)
    public ResponseResult selectMedicineByName(@PathVariable String name){
        Medicine result= medicineService.selectMedicineByName(name);
        List<Medicine> medicines = new ArrayList<>();
        medicines.add(result);
        if(medicines!=null){
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询药品信息成功",result);
        }else{
            return new ResponseResult(ErrorCode.NOT_FOUND_ERROR.getCode(),"没有药品信息");
        }
    }

    //添加药品信息
    @RequestMapping(value = "insertMedicine",method = RequestMethod.POST)
    public ResponseResult insertMedicine(@RequestBody Medicine medicine){
        int result=medicineService.insertMedicine(medicine);
        if(result==-1){
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"药品已登记",medicine);
        }else{
            if(result>=1)
                return new ResponseResult(ErrorCode.SUCCESS.getCode(),"药品信息增加成功",medicine);
            else
                return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"药品信息增加失败",medicine);
        }
    }

    //修改药品信息
    @RequestMapping(value = "updateMedicine",method = RequestMethod.POST)
    public ResponseResult updateMedicine(@RequestBody Medicine medicine){
        int result=medicineService.updateMedicine(medicine);
        if(result>=1)
            return new ResponseResult(ErrorCode.SUCCESS.getCode(),"药品信息修改成功",medicine);
        else{
            Medicine medicine1 = medicineService.selectMedicineByName(medicine.getMedicineName());
            return new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"药品信息修改失败",medicine1);
        }
    }

    //分页功能
    @GetMapping("/allMedicinePager2")
    @CrossOrigin
    public Object allMedicinePager2(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "8",value = "pageSize")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Medicine> list = medicineService.selectAllMedicine();
        PageInfo<Medicine> pageInfo = new PageInfo<>(list);
        return new ResponseResult(ErrorCode.SUCCESS.getCode(),"查询分页成功",pageInfo);
    }

    @RequestMapping(value = "bind",method = RequestMethod.POST)
    public ResponseResult bind(@RequestBody Medicine medicine, int quantity, int user_id) throws ParseException {
        int result=medicineService.charge(medicine,quantity,user_id);
        if(result>=1){
            return  new ResponseResult(ErrorCode.SUCCESS.getCode(),ErrorCode.SUCCESS.getMessage());
        }else if (result == -2){
            return  new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),"库存不足");
        }else{
            return  new ResponseResult(ErrorCode.OPERATION_ERROR.getCode(),ErrorCode.OPERATION_ERROR.getMessage());
        }
    }
}
