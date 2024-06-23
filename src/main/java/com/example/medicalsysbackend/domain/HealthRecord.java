package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName health_record
 */
@TableName(value ="health_record")
@Data
public class HealthRecord implements Serializable {
    /**
     * 健康档案ID
     */
    @TableId
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 基本信息/药物过敏史
     */
    private String basicInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}