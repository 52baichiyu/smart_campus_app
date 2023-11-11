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
 * @TableName recharge_record
 */
@TableName(value ="recharge_record")
@Data
public class RechargeRecord implements Serializable {
    /**
     * 充值单号
     */
    @TableId(value = "bill_no")
    private String bill_no;

    /**
     * 充值时间
     */
    @TableField(value = "date")
    private Date date;

    /**
     * 充值记录的充值金额
     */
    @TableField(value = "recharge_amount")
    private String recharge_amount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}