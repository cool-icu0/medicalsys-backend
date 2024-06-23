package com.example.medicalsysbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medicalsysbackend.domain.Prescribeprice;

import java.util.List;

/**
* @author 24235
* @description 针对表【prescribePrice】的数据库操作Service
* @createDate 2024-05-14 23:05:11
*/
public interface PrescribepriceService extends IService<Prescribeprice> {
    public List<Prescribeprice> selectAllPrescribeprice();
    public Prescribeprice selectPrescribepriceById(int id);
    public Prescribeprice selectPrescribepriceByPrescribeId(int prescribeId);
    public int insertPrescribeprice(Prescribeprice prescribeprice);
    public int updatePrescribeprice(Prescribeprice prescribeprice);
}
