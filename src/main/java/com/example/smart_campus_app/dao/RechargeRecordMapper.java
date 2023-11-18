package com.example.smart_campus_app.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.smart_campus_app.bean.RechargeRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zero
* @description 针对表【recharge_record】的数据库操作Mapper
* @createDate 2023-11-09 17:06:00
* @Entity com.example.mybatis_plus.entity.RechargeRecord
*/
@Mapper
public interface RechargeRecordMapper extends BaseMapper<RechargeRecord> {

    List<RechargeRecord> selectAll();

    List<RechargeRecord> selectAllByHomeNumber(@Param("homeNumber") String homeNumber);



}




