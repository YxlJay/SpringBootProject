package com.yxl.application.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName admins
 */
@TableName(value ="admins")
@Data
public class Admins implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    @TableField(value = "loginname")
    private String loginname;

    /**
     * 
     */
    @TableField(value = "pwd")
    private String pwd;

    /**
     * 
     */
    @TableField(value = "rolename")
    private String rolename;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}