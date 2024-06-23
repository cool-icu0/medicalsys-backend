package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.Prescribeprice;
import com.example.medicalsysbackend.mapper.PrescribepriceMapper;

import com.example.medicalsysbackend.service.PrescribepriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 24235
* @description 针对表【prescribePrice】的数据库操作Service实现
* @createDate 2024-05-14 23:05:11
*/
@Service
public class PrescribepriceServiceImpl extends ServiceImpl<PrescribepriceMapper, Prescribeprice>
    implements PrescribepriceService {
    @Resource
    PrescribepriceMapper prescribepriceMapper;

    @Override
    public List<Prescribeprice> selectAllPrescribeprice() {
        return prescribepriceMapper.selectAllPrescribeprice();
    }

    @Override
    public Prescribeprice selectPrescribepriceById(int id) {
        return prescribepriceMapper.selectPrescribepriceById(id);
    }

    @Override
    public Prescribeprice selectPrescribepriceByPrescribeId(int prescribeId) {
        return prescribepriceMapper.selectPrescribepriceByPrescribeId(prescribeId);
    }

    @Override
    public int insertPrescribeprice(Prescribeprice prescribeprice) {
        return prescribepriceMapper.insertPrescribeprice(prescribeprice);
    }

    @Override
    public int updatePrescribeprice(Prescribeprice prescribeprice) {
        return prescribepriceMapper.updatePrescribeprice(prescribeprice);
    }
}




