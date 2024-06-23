package com.example.medicalsysbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.HealthCard;
import com.example.medicalsysbackend.domain.Prescribeprice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


/**
* @author 24235
* @description 针对表【prescribePrice】的数据库操作Mapper
* @createDate 2024-05-14 23:05:11
* @Entity generator.domain.Prescribeprice
*/
public interface PrescribepriceMapper extends BaseMapper<Prescribeprice> {
    @Select("select * from prescribePrice")
    public List<Prescribeprice> selectAllPrescribeprice();

    @Select("select * from prescribePrice where id = #{id}")
    public Prescribeprice selectPrescribepriceById(int id);

    @Select("select * from prescribePrice where prescribe_id = #{prescribeId}")
    public Prescribeprice selectPrescribepriceByPrescribeId(int prescribeId);

    @Insert("insert into prescribePrice VALUES(null,#{prescribeId},#{prices})")
    public int insertPrescribeprice(Prescribeprice prescribeprice);

    @Update("update prescribePrice set prescribe_id = #{prescribeId}, prices = #{prices} where id = #{id}")
    public int updatePrescribeprice(Prescribeprice prescribeprice);
}




