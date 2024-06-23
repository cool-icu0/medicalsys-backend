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
 * @TableName patient_tracking
 */
@TableName(value ="patient_tracking")
@Data
public class PatientTracking implements Serializable {
    /**
     * 跟踪记录ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 病患ID
     */
    private Integer userId;

    /**
     * 跟踪日期
     */
    private Date trackingDate;

    /**
     * 是否痊愈
     */
    private Integer isRecovery;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}