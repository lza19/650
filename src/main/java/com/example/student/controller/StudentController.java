package com.example.student.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.student.entity.FacultyEntity;
import com.example.student.entity.StudentEntity;
import com.example.student.service.FacultyService;
import com.example.student.service.StudentService;



@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/")
    public String getAll() {
        System.out.println("------getallstudent------");
        List<StudentEntity> student = studentService.getStudentAll();


        System.out.println("------getallstudent Size ------");
        System.out.println("Sudent SIUU" + student.size());
        return "student/index";
    }

    @GetMapping("/{student-id}")
    public String getById(@PathVariable(name="student-id", required = true) Integer studentid) {
        System.out.println("-------getbyidstudent--------");
        System.out.println("facultyid :" + studentid);

        StudentEntity student = studentService.getStudentById(studentid);
        System.out.println("-------SudentId : " + student.getStudentId());
        System.out.println("-------getStudentCode : " + student.getStudentCode());
        System.out.println("-------StudentFirstname : " + student.getStudentFirstname());
        System.out.println("-------StudentLastName : " + student.getStudentLastName());
        System.out.println("-------getFacultyName : " + student.getFaculty().getFacultyName());
        return "student/index";
    }
    

    @PostMapping("/")
    public String saveStudent(@RequestParam() Map<String, String> param
    ) {
        System.out.println("-------savebyidstudent-------");
        System.out.println("studentId :" + param.get("studentid"));
        System.out.println("studentcode :" + param.get("studentcode"));
        System.out.println("studentFristName :" + param.get("studentFristName"));
        System.out.println("studentLastName :" + param.get("studentLastName"));
        System.out.println("faculty :" + param.get("faculty"));

        System.out.println("-------savebyidstudent( ) REsult -------");
        Integer facultyId = Integer.parseInt(param.get("faculty"));
        FacultyEntity facultyEntity = facultyService.getFacultyById(facultyId);
        System.out.println(facultyEntity.getFacultyId());

        StudentEntity studentEntity = new StudentEntity();
        if (param.get("studentid") != null) {
            studentEntity.setStudentId(Integer.parseInt(param.get("studentid")));
        }
        studentEntity.setStudentCode(param.get("studentcode"));
        studentEntity.setStudentFirstname(param.get("studentFristName"));
        studentEntity.setStudentLastName(param.get("studentLastName"));

        return "student/index";
    }

    @GetMapping("/delete/{student-id}")
    public String deletestudentid(@PathVariable(name="student-id", required = true) Integer studentid) {
        System.out.println("-------deletestudentid--------");
        System.out.println("-------studentid :" + studentid);


        System.out.println("-------deletestudentid--------");
        studentService.deletestudent(studentid);

        return "student/index";
    }


    
    
}
