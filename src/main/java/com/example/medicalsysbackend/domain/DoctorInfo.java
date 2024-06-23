package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName doctor_info
 */
@TableName(value ="doctor_info")
@Data
public class DoctorInfo implements Serializable {
    /**
     * 医生ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 医生姓名
     */
    private String doctorName;

    /**
     * 擅长领域
     */
    private String specialty;

    /**
     * 所属医院名称
     */
    private String hospitalName;

    /**
     * 所属科室
     */
    private String department;

    /**
     * 职称
     */
    private String position;

    /**
     * 从业年限
     */
    private Integer experienceYears;

    /**
     * 医生简介
     */
    private String introduction;

    /**
     * 角色（1：医生，2：药剂师）
     */
    private Integer role;

    private String imgUrl;
    /**
     * 是否逻辑删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}