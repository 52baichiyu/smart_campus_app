//package com.example.smart_campus_app.controller;
//
//import com.example.smart_campus_app.util.JsonResult;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @ClassName TestController
// * @Description TODO
// * @Author ctfliar
// * @Date 2023/11/8 14:20
// * @Version 1.0
// **/
//@RestController
//@CrossOrigin(origins = "*")
//@Api(tags = "测试接口")
//public class TestController {
//
//
//    @GetMapping("/test")
//    @ApiOperation("测试接口连接")
//    public String test(){
//        return "连接访问成功";
//    }
//
//
//    @GetMapping("/testRespondy")
//    @ApiOperation("测试定义的返回请求体")
//    public JsonResult testRespondy(){
//
//        return JsonResult.sucess("响应返回体请求返回成功");
//    }
//
//
//
//
//
//}
