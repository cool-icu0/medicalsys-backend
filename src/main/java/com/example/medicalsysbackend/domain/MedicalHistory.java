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
 * @TableName medical_history
 */
@TableName(value ="medical_history")
@Data
public class MedicalHistory implements Serializable {
    /**
     * 病史ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID，关联用户表
     */
    private Integer userId;

    /**
     * 疾病情况描述
     */
    private String medicalCondition;

    /**
     * 诊断日期
     */
    private Date diagnosisDate;

    /**
     * 治疗情况描述
     */
    private String treatment;

    /**
     * 主治医生姓名
     */
    private String doctorName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}