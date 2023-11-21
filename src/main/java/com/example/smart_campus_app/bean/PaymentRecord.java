package com.example.smart_campus_app.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName payment_record
 */
@TableName(value ="payment_record")
@Data
public class PaymentRecord implements Serializable {
    /**
     * 消费记录的消费单号
     */
    @TableId(value = "bill_no")
    private Integer bill_no;

    /**
     * 消费时间
     */
    @TableField(value = "date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;

    /**
     * 消费金额
     */
    @TableField(value = "payament")
    private String payament;

    @TableField(value = "home_number")
    private String homeNumber;

    @TableField(value = "card_number")
    private String cardNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}