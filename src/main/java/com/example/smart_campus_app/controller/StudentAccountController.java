package com.example.smart_campus_app.controller;

import com.example.smart_campus_app.bean.StudentAccountBean;
import com.example.smart_campus_app.bean.StudentCardBean;
import com.example.smart_campus_app.service.impl.StudentServerImpl;
import com.example.smart_campus_app.util.JsonResult;
import com.google.common.collect.HashBiMap;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@CrossOrigin(origins = "*")
@Api(tags = "用户信息相关接口")
public class StudentAccountController {
@Autowired
    StudentServerImpl studentServer;

    @GetMapping("/GetUserDate")
    public JsonResult GetUserDate(@RequestParam("student_number") String student_number)
    {
        int CODE = MY_FALSE;
        String MSG = "Gain The User Date Failure! Please Check The Student Number!";
        JsonResult js = new JsonResult();
        HashMap<String,String> js_object = new HashMap<String, String>();

        List<StudentAccountBean> date = studentServer.get_student_account(String.valueOf(student_number));
        List< StudentCardBean> date_card = studentServer.seek_student_card(student_number);
        if(date.size() != 0 || date_card.size() !=0)
        {
            CODE = MY_OK;
            MSG = "Gain Date Success!";
//            int stundent_number;
//            String student_name;
//            int sex;
//            String specialized;
//            String school_name;
//            String academy;
//            String home_number;
            js_object.put("stundent_number",String.valueOf(date.get(0).getStundent_number()));
            js_object.put("stundent_name",date.get(0).getStudent_name());
            js_object.put("sex",String.valueOf(date.get(0).getSex()));
            js_object.put("specialized",date.get(0).getSpecialized());
            js_object.put("school_name",date.get(0).getSchool_name());
            js_object.put("academy",date.get(0).getAcademy());
            js_object.put("home_number",date.get(0).getHome_number());
            js_object.put("card_number",date_card.get(0).getCard_number());
            js.setObj(js_object);

        }
        js.setCode(CODE);
        js.setMsg(MSG);

        return js;
    }

@PostMapping(value = "/UpdateUserDate",produces = "application/json;charset=UTF-8")
    public JsonResult UpdateUserDate(@RequestBody StudentAccountBean st_body)
    {
        JsonResult js = new JsonResult();
        int CODE = MY_FALSE;
        String MSG = "Update Failure!";
        int sig_update = studentServer.update_student_account(st_body.getSex(),st_body.getSpecialized(),
                st_body.getSchool_name(),st_body.getAcademy(), String.valueOf(st_body.getStundent_number()));
        if(sig_update > 0)
        {
        CODE = MY_OK;
        MSG = "Update Success!";
        }
        js.setMsg(MSG);
        js.setCode(CODE);
        return  js;
    }



}
