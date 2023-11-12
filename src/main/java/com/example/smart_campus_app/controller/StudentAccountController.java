package com.example.smart_campus_app.controller;

import com.example.smart_campus_app.bean.StudentAccountBean;
import com.example.smart_campus_app.service.impl.StudentServerImpl;
import com.example.smart_campus_app.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.smart_campus_app.controller.BaseController.MY_FALSE;
import static com.example.smart_campus_app.controller.BaseController.MY_OK;

/**
*@Description
* StudentAccountController
*@Expositor 余.
*@Date Created in 2023/11/11 22:51
**/
@RestController
@RequestMapping("/user")
public class StudentAccountController {
@Autowired
    StudentServerImpl studentServer;

    @GetMapping("/GetUserDate")
    public JsonResult GetUserDate(@RequestParam("student_number") String student_number)
    {
        int CODE = MY_FALSE;
        String MSG = "Gain The User Date Failure! Please Check The Student Number!";
        JsonResult js = new JsonResult();
        List<StudentAccountBean> date = studentServer.get_student_account(student_number);
        if(date.size() != 0)
        {
            CODE = MY_OK;
            MSG = "Gain Date Success!";
            js.setObj(date);
        }
        js.setCode(CODE);
        js.setMsg(MSG);

        return js;
    }



}
