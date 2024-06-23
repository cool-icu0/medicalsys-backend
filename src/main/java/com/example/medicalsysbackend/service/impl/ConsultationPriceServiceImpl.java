package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.ConsultationPrice;
import com.example.medicalsysbackend.mapper.ConsultationPriceMapper;
import com.example.medicalsysbackend.mapper.ConsultationRecordMapper;
import com.example.medicalsysbackend.service.ConsultationPriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Cool
* @description 针对表【consultation_price】的数据库操作Service实现
* @createDate 2024-04-22 21:59:50
*/
@Service
public class ConsultationPriceServiceImpl extends ServiceImpl<ConsultationPriceMapper, ConsultationPrice>
    implements ConsultationPriceService {
    @Resource
    ConsultationPriceMapper consultationPriceMapper;

    @Override
    public List<ConsultationPrice> selectAllConsultation_price() {
        return consultationPriceMapper.selectAllConsultation_price();
    }

    @Override
    public ConsultationPrice selectConsultationPriceByPosition(String position) {
        return consultationPriceMapper.selectConsultationPriceByPosition(position);
    }

    @Override
    public ConsultationPrice selectConsultationPriceById(int id) {
        return consultationPriceMapper.selectConsultationPriceById(id);
    }

    @Override
    public int insertConsultationPrice(ConsultationPrice consultationPrice) {
        return consultationPriceMapper.insertConsultationPrice(consultationPrice);
    }

    @Override
    public int updateConsultationPrice(ConsultationPrice consultationPrice) {
        return consultationPriceMapper.updateConsultationPrice(consultationPrice);
    }
}




