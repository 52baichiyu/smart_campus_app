package com.example.smart_campus_app.service;

import com.example.smart_campus_app.bean.StudentAccountBean;
import com.example.smart_campus_app.bean.StudentCardBean;

import java.util.List;

/**
*@Description
* StudentServer
*@Expositor 余.
*@Date Created in 2023/11/11 22:47
**/
public interface StudentServer {

    public List<StudentAccountBean> get_student_account(String student_account);
    public int update_student_account(    int sex,
                                          String specialized, String school_name, String academy, String s_student_number);
    public List<StudentCardBean> seek_student_card(String student_number);
}
