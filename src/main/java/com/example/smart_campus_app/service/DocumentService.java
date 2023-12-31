package com.example.smart_campus_app.service;

import com.example.smart_campus_app.bean.Document;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
* @author zero
* @description 针对表【document】的数据库操作Service
* @createDate 2023-11-09 16:45:54
*/
//@Mapper
public interface DocumentService extends IService<Document> {



    public List<Document> selectAll();


    public List<Document> selectByDate(Date date);



}
