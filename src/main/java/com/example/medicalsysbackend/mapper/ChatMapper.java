package com.example.medicalsysbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.Chat;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Cool
* @description 针对表【chat】的数据库操作Mapper
* @createDate 2024-06-06 20:07:15
* @Entity com.example.medicalsysbackend.domain.Chat
*/
public interface ChatMapper extends BaseMapper<Chat> {

    @Select("select * from chat")
    List<Chat> findAll();
}




