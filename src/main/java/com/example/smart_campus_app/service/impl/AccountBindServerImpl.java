package com.example.smart_campus_app.service.impl;

import com.example.smart_campus_app.bean.AccountBindBean;
import com.example.smart_campus_app.bean.StudentCardBean;
import com.example.smart_campus_app.dao.AccountBindDao;
import com.example.smart_campus_app.dao.StudentCardDao;
import com.example.smart_campus_app.service.AccountBindServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
*@Description
*
*@Expositor 余.
*@Date Created in 2023/11/7 17:01
**/
@Service
public class AccountBindServerImpl implements AccountBindServer {
    @Autowired
    AccountBindDao account_bind_dao;
    @Autowired
    StudentCardDao student_card_dao;
    @Override
    public List<AccountBindBean> query_all() {
        List<AccountBindBean> test =account_bind_dao.query_all();
        System.out.println(test.get(0));
        return test;
    }
    @Override
    public List<AccountBindBean> seek_by_code(String user_code) {
        return account_bind_dao.seek_by_code(user_code);
    }

    @Override
    public List<AccountBindBean> seek_by_stu_number(String student_number) {
        return account_bind_dao.seek_by_stu_number(student_number);
    }

    @Override
    public int insert_code(String user_code, String student_number) {
        return account_bind_dao.insert_code(user_code, student_number);
    }

    @Override
    public List<StudentCardBean> seek_student_number(String student_number, String password) {
        return student_card_dao.seek_student_number(student_number, password);
    }

    @Override
    public int relieve_bind(String student_number) {
        return account_bind_dao.relieve_bind(student_number);
    }
}
