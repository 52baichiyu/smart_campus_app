package com.example.smart_campus_app.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course implements Serializable {
    /**
     * 课程号
     */
    @TableId(value = "course_number")
    private String course_number;

    /**
     * 课程名
     */
    @TableField(value = "course_name")
    private String course_name;

    /**
     * 老师
     */
    @TableField(value = "teacher")
    private String teacher;

    /**
     * 学期
     */
    @TableField(value = "semester")
    private String semester;

    /**
     * 周次
     */
    @TableField(value = "number")
    private String number;

    /**
     * 星期几，第几大节,两个字符用逗号隔开存储
     */
    @TableField(value = "a_b")
    private String a_b;

    /**
     * 上课周数，从第几周开始，到第几周结束，两个字符使用逗号隔开
     */
    @TableField(value = "week")
    private String week;

    /**
     * 上课教室
     */
    @TableField(value = "place")
    private String place;

    /**
     * 系统备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 课程性质
     */
    @TableField(value = "type")
    private String type;

    /**
     * 考核方式
     */
    @TableField(value = "assess_type")
    private String assess_type;

    /**
     * 学分
     */
    @TableField(value = "credits")
    private String credits;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}