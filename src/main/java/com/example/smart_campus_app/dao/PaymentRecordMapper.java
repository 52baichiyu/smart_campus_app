package com.example.smart_campus_app.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.smart_campus_app.bean.PaymentRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zero
* @description 针对表【payment_record】的数据库操作Mapper
* @createDate 2023-11-09 17:05:41
* @Entity com.example.mybatis_plus.entity.PaymentRecord
*/
@Mapper
public interface PaymentRecordMapper extends BaseMapper<PaymentRecord> {
    List<PaymentRecord> selectByBill_no(@Param("bill_no") Integer bill_no);

    List<PaymentRecord> selectAllByHomeNumber(@Param("homeNumber") String homeNumber);

}




