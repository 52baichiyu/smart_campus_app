package com.example.smart_campus_app.bean;

import lombok.Data;

@Data
public class StudentAccountBean {
   int stundent_number;
   String student_name;
    int sex;
    String specialized;
    String school_name;
    String academy;
    String home_number;
    //宿舍电费余额字段
    String home_money;

}
