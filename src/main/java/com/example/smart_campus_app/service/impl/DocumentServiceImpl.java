package com.example.smart_campus_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smart_campus_app.bean.Document;
import com.example.smart_campus_app.service.DocumentService;
import com.example.smart_campus_app.dao.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author zero
* @description 针对表【document】的数据库操作Service实现
* @createDate 2023-11-09 16:45:54
*/
@Service
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document>
    implements DocumentService{



    @Autowired
    DocumentMapper documentMapper;


    @Override
    public List<Document> selectAll() {
        return  documentMapper.selectAll();
    }

    @Override
    public List<Document> selectByDate(Date date) {
        return documentMapper.selectAllByDate(date);
    }
}




