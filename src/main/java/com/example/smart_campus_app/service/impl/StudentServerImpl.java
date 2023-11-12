package com.example.smart_campus_app.service.impl;

import com.example.smart_campus_app.bean.StudentAccountBean;
import com.example.smart_campus_app.dao.StudentAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*@Description
* StudentServerImpl
*@Expositor 余.
*@Date Created in 2023/11/11 22:48
**/
@Service
public class StudentServerImpl implements StudentServer{

    @Autowired
    StudentAccountDao studentAccountDao;

    @Override
    public List<StudentAccountBean> get_student_account(String student_account) {
        return studentAccountDao.get_student_account(student_account);
    }

    @Override
    public int update_student_account(int sex, String specialized, String school_name, String academy, String s_student_number) {
        return studentAccountDao.update_student_account(sex, specialized, school_name, academy, s_student_number);
    }
}
