package com.example.student.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.student.entity.CousreEntity;
import com.example.student.service.CourseService;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/Course")
    public String getAll() {
        System.out.println("----------getAllCourse---------");

        List<CousreEntity> coruses = courseService.getCourseAll();
        System.out.println("getAllCourse ()");
        System.out.println("getAllCourse ()" + coruses.size());
        return "course/index";
    }

    @GetMapping("/Course/{Course-id}")
    public String getidCourse(@PathVariable(name="Course-id" ,required = true ) Integer CourseId ) {
        System.out.println("---------getCourseId----------");
        System.out.println("CourseId :" + CourseId);

        CousreEntity entity = courseService.getCourseById(CourseId);
        System.out.println("---------getCourseId() ----------");
        System.out.println("course Name :" + entity.getCourseName());


        return "course/index";
    }


    @PostMapping("/Course")
    public String saveCourse(@RequestParam() Map<String, String> param
    ) {
        System.out.println("-------saveCourseid-------");
        System.out.println("CourseId :" + param.get("CourseId"));
        System.out.println("CourseName :" + param.get("CourseName"));
        System.out.println("CourseDescription :" + param.get("CourseDescription"));

        System.out.println("CourseDescription ()");
        CousreEntity entity = new CousreEntity();
        if (null != param.get("CourseId")) {
            entity.setCourseId(Integer.parseInt(param.get("CourseId")));

            
        }
        entity.setCourseName(param.get("CourseName"));
        entity.setCourseDescription(param.get("CourseDescription"));
        CousreEntity result = courseService.saveCourse(entity);
        System.out.println("CourseId :" + result.getCourseId());
        System.out.println(" Couse name" + result.getCourseName());

        return "course/index";
    }

    @GetMapping("/delete/{Course-id}")
    public String deleteCourse(@PathVariable(name="Course-Id", required = true) Integer CourseId) {
        System.out.println("-------deleteCourseId--------");
        System.out.println("-------CourseId :" + CourseId);

        System.out.println("-------CourseId--------- :");
        courseService.deleteCourseById(CourseId);
        return "course/index";

    }
    
    
    
    
    
}
