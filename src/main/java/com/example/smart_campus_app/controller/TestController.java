package com.example.smart_campus_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/11/8 14:20
 * @Version 1.0
 **/
@RestController
public class TestController {


    @RequestMapping("/test")
    public String test(){
        return "连接访问成功";
    }

}
