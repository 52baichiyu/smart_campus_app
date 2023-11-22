package com.example.smart_campus_app.dao;
import org.apache.ibatis.annotations.Param;

import com.example.smart_campus_app.bean.StudentAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zero
* @description 针对表【student_account】的数据库操作Mapper
* @createDate 2023-11-09 17:06:13
* @Entity com.example.mybatis_plus.entity.StudentAccount
*/
@Mapper
public interface StudentAccountMapper extends BaseMapper<StudentAccount> {
    StudentAccount selectOneByHomeNumber(@Param("homeNumber") String homeNumber);

    int updateHome_moneyByHomeNumber(@Param("homeMoney") String homeMoney, @Param("homeNumber") String homeNumber);



}




