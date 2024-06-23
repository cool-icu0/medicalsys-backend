package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.ConsultationRecord;
import com.example.medicalsysbackend.domain.HealthCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【health_card】的数据库操作Mapper
* @createDate 2024-04-22 22:00:08
* @Entity generator.domain.HealthCard
*/
public interface HealthCardMapper extends BaseMapper<HealthCard> {
    @Select("select * from health_card")
    public List<HealthCard> selectAllHealthCard();

    @Select("select * from health_card where card_id = #{cardId}")
    public HealthCard selectHealthCardById(int cardId);

    @Select("select * from health_card where user_id = #{userId}")
    public HealthCard selectHealthCardByUserId(int userId);

    @Select("select * from health_card where card_number = #{cardNumber}")
    public HealthCard selectHealthCardByCardNumber(String cardNumber);

    @Insert("insert into health_card VALUES(null,#{cardNumber},#{userId},#{holderName},#{expirationDate},#{cardPrices},0)")
    public int insertHealthCard(HealthCard healthCard);

    @Update("update health_card set card_number = #{cardNumber}, user_id = #{userId}, holder_name = #{holderName}, expiration_date = #{expirationDate}, card_prices = #{cardPrices}, is_delete = #{isDelete} where card_id = #{cardId}")
    public int updateHealthCard(HealthCard healthCard);
}




