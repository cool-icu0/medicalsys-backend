package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.ConsultationPrice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.Topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author Cool
* @description 针对表【consultation_price】的数据库操作Mapper
* @createDate 2024-04-22 21:59:50
* @Entity generator.domain.ConsultationPrice
*/
public interface ConsultationPriceMapper extends BaseMapper<ConsultationPrice> {
    @Select("select * from consultation_price")
    public List<ConsultationPrice> selectAllConsultation_price();

    @Select("select * from consultation_price where position = #{position}")
    public ConsultationPrice selectConsultationPriceByPosition(String position);

    @Select("select * from consultation_price where id = #{id}")
    public ConsultationPrice selectConsultationPriceById(int id);

    @Insert("INSERT INTO consultation_price values(null, #{position},#{price})")
    public int insertConsultationPrice(ConsultationPrice consultationPrice);

    @Update("update consultation_price set position = #{position}, price = #{price} where id = #{id}")
    public int updateConsultationPrice(ConsultationPrice consultationPrice);
}




