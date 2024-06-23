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
 * @TableName topic
 */
@TableName(value ="topic")
@Data
public class Topic implements Serializable {
    /**
     * 主题ID
     */
    @TableId(type = IdType.AUTO)
    private Integer topicId;

    /**
     * 主题标题
     */
    private String title;

    /**
     * 主题内容
     */
    private String content;

    /**
     * 创建主题的用户ID
     */
    private Integer userId;

    /**
     * 创建日期
     */
    private Date createDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}