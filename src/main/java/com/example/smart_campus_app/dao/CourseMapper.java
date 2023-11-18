package com.example.smart_campus_app.dao;
import java.util.List;

import com.example.smart_campus_app.bean.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author zero
* @description 针对表【course】的数据库操作Mapper
* @createDate 2023-11-09 17:05:15
* @Entity com.example.mybatis_plus.entity.Course
*/
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> selectAll();

}




