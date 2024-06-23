package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName physical_condition
 */
@TableName(value ="physical_condition")
@Data
public class PhysicalCondition implements Serializable {
    /**
     * 身体情况ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 检查日期
     */
    private Date checkupDate;

    /**
     * 身高（单位：厘米）
     */
    private BigDecimal height;

    /**
     * 体重（单位：公斤）
     */
    private BigDecimal weight;

    /**
     * 血压
     */
    private String bloodPressure;

    /**
     * 心率（次/分钟）
     */
    private Integer heartRate;

    /**
     * 体温（单位：摄氏度）
     */
    private BigDecimal bodyTemperature;

    /**
     * 症状描述
     */
    private String symptoms;

    /**
     * 诊断结果
     */
    private String diagnosis;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}