package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天消息表
 * @TableName chat
 */
@TableName(value ="chat")
@Data
public class Chat implements Serializable {
    /**
     * 聊天记录id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发送消息id
     */
    @TableField(value = "fromId")
    private Long fromId;

    /**
     * 接收消息id
     */
    @TableField(value = "toId")
    private Long toId;

    /**
     *
     */
    @TableField(value = "text")
    private String text;

    /**
     * 聊天类型 1-私聊 2-群聊
     */
    @TableField(value = "chatType")
    private Integer chatType;

    /**
     * 创建时间
     */
    @TableField(value = "createTime")
    private Date createTime;

    /**
     *
     */
    @TableField(value = "updateTime")
    private Date updateTime;

    /**
     *
     */
    @TableField(value = "teamId")
    private Long teamId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}