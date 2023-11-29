package com.example.smart_campus_app.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.smart_campus_app.bean.Course;
import com.example.smart_campus_app.bean.PaymentRecord;
import com.example.smart_campus_app.service.CourseService;
import com.example.smart_campus_app.service.PaymentRecordService;
import com.example.smart_campus_app.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: fanFengLi
 * @Date: 2023/11/28/23:00
 * @Description:
 */
@RestController
@Api(tags = "课程相关接口")
@RequestMapping("/course")
public class CourseController extends BaseController{


    @Autowired
    private CourseService courseService;

    private List<Course> courseList;

    @GetMapping("/selectByCourseNumber")
    @ApiOperation("通过课程号查询课程详情")
    JsonResult selectByCourseNumber(@RequestParam("courseNumber") String targetCourseNumber){

//        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Course::getCourse_number,courseNumber);
//        Course course = courseService.getOne(wrapper);
        Course courseDetail = null;
        for (Course course : courseList) {
            if (course.getCourseNumber().equals(targetCourseNumber)){
                courseDetail = course;
            }
        }
        return JsonResult.sucess(courseDetail);

    }


    //返回这第几周的课表数据，从星期一到星期天，从第一大节课到最后一节课排序
    @GetMapping("/selectByWeeksAndTerm")
    @ApiOperation("通过周次和学期查询本周课表数据")
    JsonResult selectByWeeksAndTerm(@RequestParam("weeks") String weeks, @RequestParam("term") String term){
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Course::getNumber,weeks);
        wrapper.eq(Course::getSemester,term);
        courseList = courseService.list(wrapper);
        // 打印排序前的结果
        for (Course course : courseList) {
            System.out.println(course);
        }
        // 使用Lambda表达式进行排序
        courseList.sort(Comparator.comparing(Course::getAb));
        // 打印排序后的结果
        for (Course course : courseList) {
            System.out.println(course);
        }
        return JsonResult.sucess(courseList);
    }
}
