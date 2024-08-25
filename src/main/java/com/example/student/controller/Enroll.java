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
import com.example.student.entity.EnrollEntity;
import com.example.student.entity.StudentEntity;
import com.example.student.service.CourseService;
import com.example.student.service.EnrollService;
import com.example.student.service.StudentService;



@Controller
public class Enroll {


    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EnrollService enrollService;

    @GetMapping("/Enroll")
    public String getAllEnroll() {
        System.out.println("----------getAllEnroll---------");

        List<EnrollEntity> enrolls = enrollService.getEnrollAll();
        System.out.println("getAllEnroll() result");
        System.out.println("Size : " + enrolls.size());
        return "enroll/ndex";
    }

    @GetMapping("/Enroll/{Enroll-id}")
    public String getEnrollid(@PathVariable(name="Enroll-id" ,required = true ) Integer EnrollId ) {
        System.out.println("---------getEnrollId----------");
        System.out.println("EnrollId :" + EnrollId);

        EnrollEntity entity = enrollService.getEnrollid(EnrollId);
        System.out.println("AllEnroll() result");
        System.out.println("Course Name " + entity.getCourse().getCourseName());
        System.out.println("Student F Name : " + entity.getStudent().getStudentFirstname());
        System.out.println("Student L Name " + entity.getStudent().getStudentLastName());
        return "enroll/index";
    }

    @PostMapping("/Enroll")
    public String SaveEnrollid(@RequestParam() Map<String, String> param
    ) {
        System.out.println("-------saveEnrollid-------");
        System.out.println("EnrollId :" + param.get("EnrollId"));
        System.out.println("EnrollStudent :" + param.get("EnrollStudent"));
        System.out.println("EnrollCourse :" + param.get("EnrollCourse"));

        System.out.println("-------saveEnrollid-------");
        Integer courseId = Integer.parseInt(param.get("EnrollCourse"));
        CousreEntity courseEntity = courseService.getCourseById(courseId);
        System.out.println("Course Id : " + courseEntity.getCourseId());

        System.out.println("-------saveEnrollid-------");
        Integer studentId = Integer.parseInt(param.get("EnrollStudent"));
        StudentEntity studentEntity = studentService.getStudentById(studentId);
        System.out.println("Student name : " + studentEntity.getStudentId());


        EnrollEntity entity = new EnrollEntity();
        if (null != param.get("enroll-id")) {
            entity.setEnrollId(Integer.parseInt(param.get("enroll-id")));
        }
        entity.setCourse(courseEntity);
        entity.setStudent(studentEntity);
        EnrollEntity result =enrollService.saveEnroll(entity);
        System.out.println("enroll-id : " + result.getEnrollId());
        System.out.println("Course name : " + result.getCourse().getCourseName());
        System.out.println("Student code : " + result.getStudent().getStudentCode());
        return "enroll/index";
    }

    @GetMapping("/Enroll/delete/{Enroll-id}")
    public String deleteEnrollid(@PathVariable(name="Enroll-id", required = true) Integer enrollId) {
        System.out.println("-------deleteEnrollId--------");
        System.out.println("-------EnrollId :" + enrollId);

        System.out.println("deleteEnrollId() result ");
        enrollService.deleteEnrollId(enrollId);
        return "enroll/index";
    }


    
    
    


    
}
