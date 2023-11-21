package com.example.smart_campus_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smart_campus_app.bean.RechargeRecord;
import com.example.smart_campus_app.service.RechargeRecordService;
import com.example.smart_campus_app.dao.RechargeRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<RechargeRecord> selectAll(String homeNumber) {
        return rechargeRecordMapper.selectAllByHomeNumber(homeNumber);
    }

    @Override
    public List<RechargeRecord> seleceByCardNumber(String cardNumber) {
        return rechargeRecordMapper.selectAllByCardNumber(cardNumber);
    }
}




