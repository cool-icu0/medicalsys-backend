package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.domain.UserDoctor;
import com.example.medicalsysbackend.mapper.UserDoctorMapper;

import com.example.medicalsysbackend.service.UserDoctorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 24235
* @description 针对表【user_doctor】的数据库操作Service实现
* @createDate 2024-05-31 22:17:39
*/
@Service
public class UserDoctorServiceImpl extends ServiceImpl<UserDoctorMapper, UserDoctor>
    implements UserDoctorService {
    @Resource
    UserDoctorMapper userDoctorMapper;
    @Override
    public UserDoctor selectUserDoctorByUserId(int uid) {
        return userDoctorMapper.selectUserDoctorByUserId(uid);
    }

    @Override
    public UserDoctor selectUserDoctorByDocId(int did) {
        return userDoctorMapper.selectUserDoctorByDocId(did);
    }
}




