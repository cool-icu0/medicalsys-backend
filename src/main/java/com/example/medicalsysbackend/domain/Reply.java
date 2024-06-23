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
 * @TableName reply
 */
@TableName(value ="reply")
@Data
public class Reply implements Serializable {
    /**
     * 回复ID
     */
    @TableId(type = IdType.AUTO)
    private Integer replyId;

    /**
     * 关联的主题ID
     */
    private Integer topicId;

    /**
     * 回复用户的ID
     */
    private Integer userId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 回复日期
     */
    private Date replyDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}