package com.example.medicalsysbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.domain.UserDoctor;
import org.apache.ibatis.annotations.Select;


/**
* @author 24235
* @description 针对表【user_doctor】的数据库操作Mapper
* @createDate 2024-05-31 22:17:39
* @Entity generator.domain.UserDoctor
*/
public interface UserDoctorMapper extends BaseMapper<UserDoctor> {
    @Select("select * from user_doctor where user_id = #{uid}")
    UserDoctor selectUserDoctorByUserId(int uid);

    @Select("select * from user_doctor where doc_id = #{did}")
    UserDoctor selectUserDoctorByDocId(int did);


}




