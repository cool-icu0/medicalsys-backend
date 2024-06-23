package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName user_doctor
 */
@TableName(value ="user_doctor")
@Data
public class UserDoctor implements Serializable {
    /**
     * 
     */
    @TableId(value = "user_id")
    private Integer userId;

    /**
     * 
     */
    @TableField(value = "doc_id")
    private Integer docId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}