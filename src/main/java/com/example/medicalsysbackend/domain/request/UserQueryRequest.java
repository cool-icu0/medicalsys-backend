package com.example.medicalsysbackend.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: axin
 * @Date: 2023年03月25日 18:00
 * @Version: 1.0
 * @Description:
 */
@Data
public class UserQueryRequest implements Serializable {

    private static final long serialVersionUID = 8245489531033247232L;
    /**
     * 查询用户
     */
    private String searchText;
}
