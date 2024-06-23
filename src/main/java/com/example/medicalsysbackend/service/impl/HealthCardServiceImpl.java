package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.HealthCard;
import com.example.medicalsysbackend.service.HealthCardService;
import com.example.medicalsysbackend.mapper.HealthCardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
* @author Cool
* @description 针对表【health_card】的数据库操作Service实现
* @createDate 2024-04-22 22:00:08
*/
@Service
public class HealthCardServiceImpl extends ServiceImpl<HealthCardMapper, HealthCard>
    implements HealthCardService{
    @Resource
    HealthCardMapper healthCardMapper;

    @Override
    public List<HealthCard> selectAllHealthCard() {
        return healthCardMapper.selectAllHealthCard();
    }

    @Override
    public HealthCard selectHealthCardById(int cardId) {
        return healthCardMapper.selectHealthCardById(cardId);
    }

    @Override
    public HealthCard selectHealthCardByUserId(int userId) {
        return healthCardMapper.selectHealthCardByUserId(userId);
    }

    @Override
    public HealthCard selectHealthCardByCardNumber(String cardNumber) {
        return healthCardMapper.selectHealthCardByCardNumber(cardNumber);
    }

    @Override
    public int insertHealthCard(HealthCard healthCard) throws ParseException {
        HealthCard healthCard1 = healthCardMapper.selectHealthCardByCardNumber(healthCard.getCardNumber());
        if (healthCard1 != null) return  -2;
        return healthCardMapper.insertHealthCard(healthCard);
    }

    @Override
    public int updateHealthCard(HealthCard healthCard) {
        return healthCardMapper.updateHealthCard(healthCard);
    }
}




