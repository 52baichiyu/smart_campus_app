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
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    private List<Course> filteredCourses;

    @GetMapping("/selectByCourseNumber")
    @ApiOperation("通过课程号查询课程详情")
    JsonResult selectByCourseNumber(@RequestParam("courseNumber") String targetCourseNumber){
        Course courseDetail = null;
        for (Course course : filteredCourses) {
            if (course.getCourseNumber().equals(targetCourseNumber)){
                courseDetail = course;
            }
        }
        return JsonResult.sucess(courseDetail);
    }


    //返回这第几周的课表数据，从星期一到星期天，从第一大节课到最后一节课排序
    @GetMapping("/selectByWeeksAndTerm")
    @ApiOperation("通过学生学号、周次和学期查询本周课表数据")
    JsonResult selectByWeeksAndTerm(@RequestParam("studentNumber") String studentNumber, @RequestParam("targetWeek") int targetWeek, @RequestParam("term") String term){
        LambdaQueryWrapper<Course> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Course::getNumber,studentNumber);
        wrapper.eq(Course::getSemester,term);
        List<Course> courseList = courseService.list(wrapper);

        // 筛选对应周次的课程
        filteredCourses = courseList.stream()
                .filter(course -> isWeekInRange(course, targetWeek))
                .collect(Collectors.toList());

        // 使用Lambda表达式进行排序
        filteredCourses.sort(Comparator.comparing(Course::getAb));

        return JsonResult.sucess(filteredCourses);
    }
    private static boolean isWeekInRange(Course course, int targetWeek) {
        String[] weekRange = course.getWeek().split(",");
        int startWeek = Integer.parseInt(weekRange[0]);
        int endWeek = Integer.parseInt(weekRange[1]);

        return targetWeek >= startWeek && targetWeek <= endWeek;
    }
}
