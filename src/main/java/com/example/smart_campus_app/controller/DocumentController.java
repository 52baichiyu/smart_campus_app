package com.example.smart_campus_app.controller;

import com.example.smart_campus_app.bean.Document;
import com.example.smart_campus_app.service.DocumentService;
import com.example.smart_campus_app.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName DocumentController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/11/12 14:09
 * @Version 1.0
 **/
@RestController
@Api(tags = "文档公告相关接口")
public class DocumentController {


    @Autowired
    DocumentService documentService;


    @GetMapping("/selectAll")
    @ApiOperation("查询所有文件")
    public JsonResult selectAll(){
        List<Document> document = documentService.selectAll();
        return JsonResult.sucess(document);
    };


    @GetMapping("/selectByDate")
    @ApiOperation("通过某一天的时间查询文件")
    public JsonResult selectByDate(@RequestParam("date") String date) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sf.parse(date);
        List<Document> document = documentService.selectByDate(date1);
        return JsonResult.sucess(document);
    };



}
