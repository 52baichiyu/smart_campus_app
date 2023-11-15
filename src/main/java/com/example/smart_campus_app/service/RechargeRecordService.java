package com.example.smart_campus_app.service;

import com.example.smart_campus_app.bean.RechargeRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author zero
* @description 针对表【recharge_record】的数据库操作Service
* @createDate 2023-11-09 17:06:00
*/
public interface RechargeRecordService extends IService<RechargeRecord> {

    List<RechargeRecord> selectAll(String homeNumber);
}
