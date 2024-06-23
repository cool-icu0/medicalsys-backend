package com.example.medicalsysbackend.mapper;

import com.example.medicalsysbackend.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Cool
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2024-04-22 22:00:38
 * @Entity generator.domain.User
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where user_id = #{id}")
    User selectUserById(int id);

    @Select("select * from user where user_account=#{username}")
    User SelectUserByUserName(String username);

    @Insert("insert into user value(null,#{user_account},#{password},#{username},null,null,#{email},null,0,null,null,0,0)")
    @Options(useGeneratedKeys=true, keyProperty="user_id", keyColumn="user_id")
    int insertUser(User user);
    @Select("select * from user where user_account=#{userAccount} ")
//    @Select("select * from user where user_account=#{userAccount} and password=#{userPassword}")
    User userLogin(String userAccount);

    /**
     * 计算用户数量
     * @param userAccount 用户账号
     * @return 同账号用户数量
     */
    @Select("SELECT COUNT(*) FROM user where user_account=#{userAccount}")
    int getUserCount(String userAccount);

    /**
     * 根据账号返回用户信息
     * @param userAccount 账号
     * @return 用户信息
     */
    @Select("SELECT * FROM user where user_account=#{userAccount}")
    User getUserByUserAccount(String userAccount);

    /**
     * 更新用户信息 （xml实现）
     * @param existingUser 待更新用户信息
     * @return
     */
    int updateUser(User existingUser);
}