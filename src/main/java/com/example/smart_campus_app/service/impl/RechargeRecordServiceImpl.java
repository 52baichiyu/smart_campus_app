package com.example.smart_campus_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smart_campus_app.bean.RechargeRecord;
import com.example.smart_campus_app.bean.StudentAccount;
import com.example.smart_campus_app.dao.StudentAccountMapper;
import com.example.smart_campus_app.service.RechargeRecordService;
import com.example.smart_campus_app.dao.RechargeRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
* @author zero
* @description 针对表【recharge_record】的数据库操作Service实现
* @createDate 2023-11-09 17:06:00
*/
@Service
public class RechargeRecordServiceImpl extends ServiceImpl<RechargeRecordMapper, RechargeRecord>
    implements RechargeRecordService{


    @Autowired
    RechargeRecordMapper rechargeRecordMapper;

    @Autowired
    StudentAccountMapper studentAccountMapper;

    @Override
    public List<RechargeRecord> selectAll(String homeNumber) {
        return rechargeRecordMapper.selectAllByHomeNumber(homeNumber);
    }

    @Override
    public List<RechargeRecord> seleceByCardNumber(String cardNumber) {
        return rechargeRecordMapper.selectAllByCardNumber(cardNumber);
    }

    @Override
    public void rechargeHome(String homeNumber, int money,String cardNumber) {

        //通过宿舍号查找宿舍电费余额，更新加上money
        StudentAccount studentAccount = studentAccountMapper.selectOneByHomeNumber(homeNumber);
        String homeMoney = String.valueOf(Integer.parseInt(studentAccount.getHomeMoney())+money);
        studentAccountMapper.updateHome_moneyByHomeNumber(homeMoney,homeNumber);

        //生成一条充值记录
        RechargeRecord record = new RechargeRecord();
        record.setHomeNumber(homeNumber);
        record.setRecharge_amount(String.valueOf(money));
        record.setBill_no(UUID.randomUUID().toString().replace("_","").replace("-",""));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        record.setDate(format.parse(format.format(new Date())));
        record.setDate(new Date());
        record.setCardNumber(cardNumber);
        rechargeRecordMapper.insert(record);


    }





}




