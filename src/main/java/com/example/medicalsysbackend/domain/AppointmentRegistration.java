package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName appointment_registration
 */
@TableName(value ="appointment_registration")
@Data
public class AppointmentRegistration implements Serializable {
    /**
     * 预约ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 医院科室
     */
    @TableField(value = "hospital_department")
    private String hospitalDepartment;

    /**
     * 医生ID
     */
    @TableField(value = "doctor_id")
    private Integer doctorId;

    /**
     * 预约时间
     */
    @TableField(value = "appointment_date")
    private Date appointmentDate;

    /**
     * 价格（基本价+职称价）
     */
    @TableField(value = "app_prices")
    private Integer appPrices;

    /**
     * 是否完成预约（0：未完成，1：已完成，2：已取消）
     */
    @TableField(value = "is_complete")
    private Integer isComplete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}