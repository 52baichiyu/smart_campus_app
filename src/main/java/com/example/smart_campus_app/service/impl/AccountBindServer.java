package com.example.smart_campus_app.service.impl;

import com.example.smart_campus_app.bean.AccountBindBean;
import com.example.smart_campus_app.bean.StudentCardBean;

import java.util.List;

/**
*@Description 
* 
*@Expositor 余.
*@Date Created in 2023/11/7 17:01
**/
public interface AccountBindServer {
    public List<AccountBindBean> query_all();

    public List<AccountBindBean> seek_by_code(String user_code);
    public List<AccountBindBean> seek_by_stu_number(String student_number);

    public int insert_code(String user_code,String student_number);

    public List<StudentCardBean> seek_student_number(String student_number, String password);

}
