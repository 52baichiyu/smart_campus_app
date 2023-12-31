package com.example.smart_campus_app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smart_campus_app.bean.Course;
import com.example.smart_campus_app.service.CourseService;
import com.example.smart_campus_app.dao.CourseMapper;
import org.springframework.stereotype.Service;

/**
* @author zero
* @description 针对表【course】的数据库操作Service实现
* @createDate 2023-11-09 17:05:15
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

}




