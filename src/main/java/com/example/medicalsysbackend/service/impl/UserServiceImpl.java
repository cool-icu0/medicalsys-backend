package com.example.medicalsysbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.mapper.UserMapper;
import com.example.medicalsysbackend.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.example.medicalsysbackend.chat.ChatConstant.USER_LOGIN_STATE;

/**
 * @author Cool
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-04-22 22:00:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    /**
     * 盐值加密
     */
    private static final String SALT = "medical";

    @Resource
    private UserMapper userMapper;

    @Override
    public User SelectUserByUserName(String name) {
        return null;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public ResponseResult logout() {
        return null;
    }

    /**
     * 用户登录
     *
     * @param userAccount  用户账号
     * @param userPassword 用户密码
     * @return user对象
     */
    @Override
    public ResponseResult<User> userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR);
        }
        if (userAccount.length() < 4) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR);
        }
        if (userPassword.length() < 8) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR);
        }
        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 查询用户是否存在
        User user = userMapper.userLogin(userAccount);
        // 用户不存在
        if (user == null) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR);
        }
        if (!user.getPassword().equals(userPassword)) {
            // 3. 记录用户的登录jwt态（user）存到redis（校验jwt，如果不存在，则重新生成）
            //4.返回数据到前端
            return new ResponseResult<>(ErrorCode.PASSWORD_ERROR);
        }
        request.getSession().setAttribute(USER_LOGIN_STATE,user);
        return new ResponseResult<>(ErrorCode.SUCCESS, user);
    }

    /**
     * 用户注册
     *
     * @param user 用户
     * @return user对象
     */
    @Override
    public ResponseResult<User> userRegister(User user) {
        String userAccount = user.getUserAccount();
        String userPassword = user.getPassword();
        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR.getCode(), "参数为空",user);
        }
        if (userAccount.length() < 4) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR.getCode(), "用户账号过短",user);
        }
        if (userPassword.length() < 8) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR.getCode(), "用户密码过短",user);
        }
        synchronized (userAccount.intern()) {
            // 账户不能重复
            int count = userMapper.getUserCount(userAccount);
            if (count > 0) {
                return new ResponseResult<>(ErrorCode.PARAMS_ERROR.getCode(),"账号重复",user);
            }
            // 2. 加密
            String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
            // 3. 插入数据
            User userReg = new User();
            userReg.setUserAccount(userAccount);
            userReg.setPassword(encryptPassword);
            //这里实现注册功能
            boolean saveResult = this.save(user);
            if (!saveResult) {
                return new ResponseResult<>(ErrorCode.SYSTEM_ERROR.getCode(),"注册失败，数据库错误",user);
            }
            return new ResponseResult<>(ErrorCode.SUCCESS,user);
        }
    }

    /**
     * 更新用户
     * @param user User对象
     * @return User对象
     */
    @Override
    public User updateUser(User user) {
        System.out.println("这个是传入的值"+user.getUsername());
        // 根据 user 中的 userAccount 查找现有用户信息
        User existingUser = userMapper.getUserByUserAccount(user.getUserAccount());
        System.out.println(existingUser+"这个是原始值");

        if (existingUser != null) {
            // 更新用户信息
            if (user.getUsername() != null) {
                existingUser.setUsername(user.getUsername().trim());
                System.out.println("这个是修改后的值"+existingUser.getUsername());
            }
            if (user.getFullName() != null) {
                existingUser.setFullName(user.getFullName());
            }
            if (user.getUserAvatar() != null) {
                existingUser.setUserAvatar(user.getUserAvatar());
            }
            if (user.getPhone() != null) {
                existingUser.setPhone(user.getPhone());
            }
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.getSignature() != null) {
                existingUser.setSignature(user.getSignature());
            }
            if (user.getGender() != null) {
                existingUser.setGender(user.getGender());
            }
            if (user.getBirthday() != null) {
                existingUser.setBirthday(user.getBirthday());
            }
            if (user.getAge() != null) {
                existingUser.setAge(user.getAge());
            }
            // 执行更新操作
            int rowsAffected = userMapper.updateUser(existingUser);
            System.out.println("受影响行数"+rowsAffected);
            if (rowsAffected > 0) {
                // 更新成功，返回更新后的用户信息
                return existingUser;
            } else {
                // 更新失败
                return null;
            }
        } else {
            // 找不到对应的用户信息，更新失败
            return null;
        }
    }

    /**
     * 根据账号查询用户信息
     * @param userAccount 用户账号
     * @return User对象
     */
    @Override
    public User getUserByUserAccount(String userAccount) {
        return userMapper.getUserByUserAccount(userAccount);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    /**
     * 用户注销
     *
     * @param request 请求
     * @return
     */
    @Override
    public int userLogout(HttpServletRequest request) {
        //移除登录态
        request.getSession().removeAttribute(USER_LOGIN_STATE);
        return 0;
    }

    @Override
    public User getLoginUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        return (User) userObj;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList= userMapper.getAllUser();
        return userList;
    }

}