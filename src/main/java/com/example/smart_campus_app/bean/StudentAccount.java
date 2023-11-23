package com.example.smart_campus_app.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student_account
 */
@TableName(value ="student_account")
@Data
public class StudentAccount implements Serializable {
    /**
     * 学号
     */
    @TableField(value = "stundent_number")
    private Integer stundent_number;

    /**
     * 学生姓名
     */
    @TableField(value = "student_name")
    private String student_name;

    @TableField(value = "home_number")
    private String homeNumber;
    /**
     * 0表示男的，1表示女的
     */
    @TableField(value = "sex")
    private Boolean sex;

    /**
     * 专业
     */
    @TableField(value = "specialized")
    private String specialized;

    /**
     * 学校名称
     */
    @TableField(value = "school_name")
    private String school_name;

    /**
     * 学院
     */
    @TableField(value = "academy")
    private String academy;


    @TableField(value = "home_money")
    private String homeMoney;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}