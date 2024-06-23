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
 * @TableName health_card
 */
@TableName(value ="health_card")
@Data
public class HealthCard implements Serializable {
    /**
     * 医保卡ID
     */
    @TableId(type = IdType.AUTO)
    private Integer cardId;

    /**
     * 医保卡号（唯一）
     */
    private String cardNumber;

    /**
     * 持卡人ID
     */
    private Integer userId;

    /**
     * 持卡人姓名
     */
    private String holderName;

    /**
     * 过期日期
     */
    private String expirationDate;

    /**
     * 余额
     */
    private Double cardPrices;

    /**
     * 是否逻辑删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}