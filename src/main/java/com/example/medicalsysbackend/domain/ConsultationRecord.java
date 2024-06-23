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
 * @TableName consultation_record
 */
@TableName(value ="consultation_record")
@Data
public class ConsultationRecord implements Serializable {
    /**
     * 问诊记录ID
     */
    @TableId
    private Integer id;

    /**
     * 诊断日期
     */
    private Date evaluationDate;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 医生ID
     */
    private Integer doctorId;

    /**
     * 满意度评分
     */
    private Integer satisfactionRating;

    /**
     * 满意度评价
     */
    private String advice;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}