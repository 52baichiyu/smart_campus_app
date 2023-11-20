package com.example.smart_campus_app.controller;

import com.example.smart_campus_app.bean.AccountBindBean;
import com.example.smart_campus_app.bean.StudentCardBean;
import com.example.smart_campus_app.service.impl.AccountBindServerImpl;
import com.example.smart_campus_app.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.example.smart_campus_app.controller.BaseController.MY_FALSE;
import static com.example.smart_campus_app.controller.BaseController.MY_OK;

/**
*@Description
*
*@Expositor 余.
*@Date Created in 2023/11/7 17:01
**/

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
@Api(tags = "用户绑定相关接口")
public class AccountBindController {
    @Autowired
    AccountBindServerImpl account_bind_server;

    @GetMapping("/QueryAll")
    public JsonResult query_all()
    {
        JsonResult js = new JsonResult();
        int CODE = MY_FALSE;
        String MSG = "Acquisition Failure!";
        List<AccountBindBean> result_account = account_bind_server.query_all();
        if (result_account.size() > 0)
        {
            CODE = MY_OK;
            MSG = "Acquisition Success!";
            System.out.println(result_account.get(0));
            js.setObj(result_account);
        }
        js.setMsg(MSG);
        js.setCode(CODE);
        return  js;

    }

    @GetMapping("/SeekByCode")
    public JsonResult seek_by_code(@RequestParam("user_code") String user_code)
    {

        JsonResult js = new JsonResult();
        int CODE = MY_FALSE;
        String MSG = "Acquisition Failure! The WeiXing Code Of WeiXing App Not Be Bind!";
        List<AccountBindBean> result_account = account_bind_server.seek_by_code(String.valueOf(user_code));
        if (result_account.size() > 0)
        {
            CODE = MY_OK;
            MSG = "Acquisition Success!";
            System.out.println(result_account.get(0));
            js.setObj(result_account);
        }
        js.setCode(CODE);
        js.setMsg(MSG);

        return  js;
    }

    @PostMapping("/InsertCode")
    public JsonResult insert_code(@RequestParam("user_code") String user_code,@RequestParam("student_number")
    String student_number,@RequestParam("student_password") String student_password)
    {
        JsonResult js = new JsonResult();
        int CODE = MY_FALSE;
        String  MSG = "Bind Failure! Please Check Student ID Card Account!";
//       String MSG = "Acquisition Failure! Not Found The WeiXing Code Of WeiXing App";
       List<StudentCardBean> result_student = account_bind_server.seek_student_number(String.valueOf(student_number),String.valueOf(student_password));
            if(result_student.size() > 0)
            {
                List<AccountBindBean> result_account = account_bind_server.seek_by_stu_number(String.valueOf(student_number));
                js.setObj(result_account);
                if (!result_account.get(0).getUser_code().equals("DEFAULT_CODE"))
                {

                    MSG = "Bind Failure! The Student Card Has Been Bind!";
                }
                else {

                    MSG = "Bind Success!";
                    int result_sig = account_bind_server.insert_code(String.valueOf(user_code),String.valueOf(student_number));
                    if (result_sig > 0)
                    {
                        CODE = MY_OK;
                        MSG = "Insert Success!";
                    }
                }
            }
        js.setCode(CODE);
        js.setMsg(MSG);
        return  js;

    }

    @PostMapping("/RelieveBind")
    public JsonResult relieve_bind(@RequestParam("student_number") String student_number)

    {
        JsonResult js = new JsonResult();
        int CODE = MY_FALSE;
        String      MSG = "Relieve Bind Failure! The Student Number Does Not Exist!";
//       String MSG = "Acquisition Failure! Not Found The WeiXing Code Of WeiXing App";
        String st_number = student_number;
            List<AccountBindBean> result_account = account_bind_server.seek_by_stu_number(String.valueOf(student_number));

            if (result_account.size() > 0)
            {
                int result_sig = account_bind_server.relieve_bind(st_number);
                if (result_sig > 0)
                {
                    CODE = MY_OK;
                    MSG = "Relieve Bind Success!";
                }

            }


        js.setCode(CODE);
        js.setMsg(MSG);
        return  js;

    }



}
