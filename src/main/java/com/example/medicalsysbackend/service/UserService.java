package com.example.medicalsysbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Cool
 * @description 针对表【user】的数据库操作Service
 * @createDate 2024-04-22 22:00:38
 */
public interface UserService extends IService<User> {
    User SelectUserByUserName(String name);
    int insertUser(User user);

    ResponseResult logout();

    /**
     * 用户登录
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return user对象
     */
    ResponseResult<User> userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户注册
     *
     * @param user User对象
     * @return 新角色id
     */
    ResponseResult<User> userRegister(User user);

    /**
     * 更新用户
     * @param user User对象
     * @return User对象
     */
    User updateUser(User user);

    /**
     * 根据账号查询用户信息
     * @param userAccount 用户账号
     * @return User对象
     */
    User getUserByUserAccount(String userAccount);

    User selectUserById(int id);

    int userLogout(HttpServletRequest request);

    User getLoginUser(HttpServletRequest request);

    List<User> getAllUser();
}