package com.example.smart_campus_app.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName document
 */
@TableName(value ="document")
@Data
public class Document implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文档标题，要求无后缀
     */
    @TableField(value = "title")
    private String title;

    /**
     * 发布人
     */
    @TableField(value = "publish_people")
    private String publish_people;

    /**
     * 发布时间
     */
    @TableField(value = "date")
    private Date date;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}