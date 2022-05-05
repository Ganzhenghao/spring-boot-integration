package com.example.springbootbeansearchstudy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @TableField(value = "name")
    private String name;


    @TableField(value = "age")
    private Integer age;


    @TableField(value = "email")
    private String email;


    @TableField(value = "phone")
    private String phone;


    @TableField(value = "gender")
    private String gender;


    @TableField(value = "create_time")
    private Date createTime;


    @TableField(value = "update_time")
    private Date updateTime;


    @TableField(value = "address")
    private String address;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}