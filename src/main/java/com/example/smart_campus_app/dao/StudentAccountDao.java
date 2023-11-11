package com.example.smart_campus_app.dao;

import com.example.smart_campus_app.bean.StudentAccountBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
*@Description
 * StudentAccountDao
*@Author 余.
*@Date Created in  2023/11/11 22:47
**/


@Mapper
public interface StudentAccountDao {

    public List<StudentAccountBean> get_student_account(String student_number);
    public int update_student_account(    int sex,
    String specialized, String school_name, String academy, String s_student_number);
}
