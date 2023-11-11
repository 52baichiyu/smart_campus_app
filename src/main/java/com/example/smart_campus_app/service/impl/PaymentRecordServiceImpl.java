package com.example.smart_campus_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smart_campus_app.bean.PaymentRecord;
import com.example.smart_campus_app.service.PaymentRecordService;
import com.example.smart_campus_app.dao.PaymentRecordMapper;
import org.springframework.stereotype.Service;

/**
* @author zero
* @description 针对表【payment_record】的数据库操作Service实现
* @createDate 2023-11-09 17:05:41
*/
@Service
public class PaymentRecordServiceImpl extends ServiceImpl<PaymentRecordMapper, PaymentRecord>
    implements PaymentRecordService{

}




