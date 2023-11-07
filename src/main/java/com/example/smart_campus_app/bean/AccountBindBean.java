package com.example.smart_campus_app.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
*@Description AccountBind Entity class
*@Author 余.
*@Date Created in  2023/11/7 13:44
**/


public class AccountBindBean {
   private String user_code;
   private String student_number;

   public String getUser_code() {
      return user_code;
   }

   public void setUser_code(String user_code) {
      this.user_code = user_code;
   }

   public String getStudent_number() {
      return student_number;
   }

   public void setStudent_number(String student_number) {
      this.student_number = student_number;
   }
}
