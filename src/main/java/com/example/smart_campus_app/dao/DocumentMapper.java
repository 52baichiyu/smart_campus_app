package com.example.smart_campus_app.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;

import com.example.smart_campus_app.bean.Document;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author zero
* @description 针对表【document】的数据库操作Mapper
* @createDate 2023-11-09 16:45:54
* @Entity com.example.mybatis_plus.entity.Document
*/
@Mapper
public interface DocumentMapper extends BaseMapper<Document> {

    List<Document> selectAllByDate(@Param("date") Date date);

    List<Document> selectAll();


}




