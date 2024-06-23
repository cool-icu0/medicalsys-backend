package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName consultation_price
 */
@TableName(value ="consultation_price")
@Data
public class ConsultationPrice implements Serializable {
    /**
     * 价格ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 问诊类型（职称价格）
     */
    private String position;

    /**
     * 价格
     */
    private Integer price;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}