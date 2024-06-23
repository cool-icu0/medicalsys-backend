package com.example.medicalsysbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName department
 */
@TableName(value ="department")
@Data
public class Department implements Serializable {
    /**
     * 科室ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 科室名称
     */
    private String departmentName;

    /**
     * 科室描述
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}