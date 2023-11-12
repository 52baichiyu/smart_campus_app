package com.example.smart_campus_app.service;

import com.example.smart_campus_app.bean.Document;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author zero
* @description 针对表【document】的数据库操作Service
* @createDate 2023-11-09 16:45:54
*/
public interface DocumentService extends IService<Document> {


    List<Document> selectAll();

    List<Document> selectByDate(Date date);

}
