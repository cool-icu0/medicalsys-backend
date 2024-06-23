package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.ConsultationPrice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Cool
* @description 针对表【consultation_price】的数据库操作Service
* @createDate 2024-04-22 21:59:50
*/
public interface ConsultationPriceService extends IService<ConsultationPrice> {
    public List<ConsultationPrice> selectAllConsultation_price();
    public ConsultationPrice selectConsultationPriceByPosition(String position);
    public ConsultationPrice selectConsultationPriceById(int id);
    public int insertConsultationPrice(ConsultationPrice consultationPrice);
    public int updateConsultationPrice(ConsultationPrice consultationPrice);
}
