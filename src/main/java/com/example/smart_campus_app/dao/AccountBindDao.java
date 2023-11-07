package com.example.smart_campus_app.dao;

import com.example.smart_campus_app.bean.AccountBindBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
*@Description Dao interface class
*@Author 余.
*@Date Created in  2023/11/7 13:48
**/

@Mapper

public interface AccountBindDao {
public List<AccountBindBean> query_all();

public List<AccountBindBean> seek_by_code(String user_code);
    public List<AccountBindBean> seek_by_stu_number(String student_number);

public int insert_code(String user_code,String student_number);


}
