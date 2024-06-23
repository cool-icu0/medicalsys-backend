package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName prescribePrice
 */
@TableName(value ="prescribePrice")
@Data
public class Prescribeprice implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "prescribe_id")
    private Integer prescribeId;

    /**
     * 
     */
    @TableField(value = "prices")
    private Double prices;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}