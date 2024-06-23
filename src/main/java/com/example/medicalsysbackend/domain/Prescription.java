package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName prescription
 */
@TableName(value ="prescription")
@Data
public class Prescription implements Serializable {
    /**
     * 处方ID
     */
    @TableId
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 处方详情
     */
    private String medicationGuide;

    /**
     * 处方日期
     */
    private Date createTime;

    /**
     * 药剂师受理状态（未受理，已受理）
     */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}