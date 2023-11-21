package com.example.smart_campus_app.dao;

import com.example.smart_campus_app.bean.AccountBindBean;
import com.example.smart_campus_app.bean.StudentCardBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.StringJoiner;

/**
*@Description Student Card Mapper class
*@Author 余.
*@Date Created in  2023/11/7 17:04
**/

@Mapper
public interface StudentCardDao {

    public List<StudentCardBean> seek_student_number(String student_number, String password);

    public List<StudentCardBean> seek_student_card(String student_number);

}
