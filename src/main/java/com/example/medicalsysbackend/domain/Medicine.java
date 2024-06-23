package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName medicine
 */
@TableName(value ="medicine")
@Data
public class Medicine implements Serializable {
    /**
     * 药品ID
     */
    @TableId(type = IdType.AUTO)
    private Integer medicineId;

    /**
     * 药品名称
     */
    private String medicineName;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 药品图片地址
     */
    private String imgUrl;

    /**
     * 单价
     */
    private Integer unitPrice;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 描述
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}