package com.example.medicalsysbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medicalsysbackend.domain.UserDoctor;


/**
* @author 24235
* @description 针对表【user_doctor】的数据库操作Service
* @createDate 2024-05-31 22:17:39
*/
public interface UserDoctorService extends IService<UserDoctor> {
    UserDoctor selectUserDoctorByUserId(int uid);
    UserDoctor selectUserDoctorByDocId(int did);
}
