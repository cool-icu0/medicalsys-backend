package com.example.medicalsysbackend.service;

import com.example.medicalsysbackend.domain.HealthCard;
import com.baomidou.mybatisplus.extension.service.IService;

import java.text.ParseException;
import java.util.List;

/**
* @author Cool
* @description 针对表【health_card】的数据库操作Service
* @createDate 2024-04-22 22:00:08
*/
public interface HealthCardService extends IService<HealthCard> {
    public List<HealthCard> selectAllHealthCard();
    public HealthCard selectHealthCardById(int cardId);
    public HealthCard selectHealthCardByUserId(int userId);
    public HealthCard selectHealthCardByCardNumber(String cardNumber);
    public int insertHealthCard(HealthCard healthCard) throws ParseException;
    public int updateHealthCard(HealthCard healthCard);
}
