package com.example.medicalsysbackend.controller;

import com.example.medicalsysbackend.common.ErrorCode;
import com.example.medicalsysbackend.common.ResponseResult;
import com.example.medicalsysbackend.domain.User;
import com.example.medicalsysbackend.domain.request.UserLoginRequest;
import com.example.medicalsysbackend.service.UserService;
import com.example.medicalsysbackend.util.JwtUtil;
import com.example.medicalsysbackend.util.RedisCache;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户接口
 */
@Api(tags = "用户控制类")
@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisCache redisCache;


    /**
     * 用户登录
     *
     * @param userLoginRequest
     * @return
     */
    @PostMapping("/login")
    public ResponseResult<User> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request) {
        System.out.println("userLoginRequest："+userLoginRequest);
        if (userLoginRequest == null) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR);
        }
        ResponseResult<User> result=userService.userLogin(userAccount, userPassword,request);
        return result;
    }

    /**
     * 用户注册
     * @param userLoginRequest
     * @return
     */
    @PostMapping("/register")
    public ResponseResult<User> userRegister(@RequestBody UserLoginRequest userLoginRequest) {
        if (userLoginRequest == null || StringUtils.isAnyBlank(userLoginRequest.getUserAccount(), userLoginRequest.getPassword())) {
            return new ResponseResult<>(ErrorCode.PARAMS_ERROR, null);
        }
        User user = new User();
        BeanUtils.copyProperties(userLoginRequest,user);
        user.setRole(0);
        // 在实际应用中，通常会进行用户注册逻辑，比如将用户信息保存到数据库
        ResponseResult<User> userRegister = userService.userRegister(user);
        // 生成 JWT Token
        String jwtToken = generateToken(user.getUserAccount());
        System.out.println(jwtToken);
        //将jwt存到数据库或者Redis
        redisCache.setCacheObject(user.getUserAccount(), jwtToken);
        return new ResponseResult<>(userRegister.getCode(),userRegister.getMsg(),userRegister.getData());
    }
    // 生成JWT Token
    private String generateToken(String username) {
        return JwtUtil.createJWT(username);
    }

    /**
     * 用户注销
     * @return
     */
    @PostMapping("/logout")
    public ResponseResult<User> userLogout(UserLoginRequest userLoginRequest, HttpServletRequest request){
        String userAccount = userLoginRequest.getUserAccount();
        int result = userService.userLogout(request);
        redisCache.deleteObject(userAccount);
        return new ResponseResult<>(200,"退出成功");
    }
    @GetMapping("/current")
    public ResponseResult<User> getCurrentUser(HttpServletRequest request) {
//        System.out.println(request.getSession().getAttribute(USER_LOGIN_STATE)+"ces2");
//        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
//        System.out.println(userObj+"ces1");
//
//        User currentUser = (User) userObj;
//        System.out.println(currentUser+"ces");
        User loginUser = userService.getLoginUser(request);
        System.err.println(loginUser);
        Integer userId = loginUser.getUserId();
        //TODO 校验用户是否合法
        User user = userService.getById(userId);
        return new ResponseResult(ErrorCode.SUCCESS,user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public ResponseResult<User> userEditInfo(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        if (updatedUser == null) {
            return new ResponseResult<>(ErrorCode.NULL_ERROR);
        }
        System.out.println("更新用户的信息"+updatedUser);
        return new ResponseResult<>(ErrorCode.SUCCESS,updatedUser);
    }

    /**
     * 根据账号搜索用户信息
     * @param userAccount 用户账号
     * @return
     */
    @GetMapping("/select/{userAccount}")
    public ResponseResult<User> getUserByUserAccount(@PathVariable String userAccount){
        User user = userService.getUserByUserAccount(userAccount);
        System.out.println(user);
        if (user == null) {
            return new ResponseResult<>(ErrorCode.NULL_ERROR);
        }
        return new ResponseResult<>(ErrorCode.SUCCESS,user);
    }
    /**
     * 搜索全部用户信息
     * @return
     */
    @GetMapping("/getUserList")
    public ResponseResult<List<User>> getUserList(){
        List<User> userList = userService.getAllUser();
        System.out.println("所有用户信息"+userList);
        if (userList == null) {
            return new ResponseResult<>(ErrorCode.NULL_ERROR);
        }
        return new ResponseResult(ErrorCode.SUCCESS,userList);
    }

}