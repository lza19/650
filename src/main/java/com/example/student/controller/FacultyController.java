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
import com.example.student.service.FacultyService;




@Controller
@RequestMapping("/faculty") //ลดชื่อ
public class FacultyController {

    @Autowired
    private FacultyService facultyService;
    //1
    @GetMapping("/")
    public String getAll() {
        System.out.println("---------getAll---------");

        List<FacultyEntity> faculties = facultyService.getFacutyAll();
        System.out.println("Size :" + faculties.size());
        return "faculty/index";
    }
    //2
    @GetMapping("/{faculty-id}")
    public String getbyId(@PathVariable(name="faculty-id", required = true) Integer facultyId) {
        System.out.println("-------getbyid--------");
        System.out.println("facultyid :" + facultyId);

        FacultyEntity entity = facultyService.getFacultyById(facultyId);
        System.out.println("-------getbyid--------");
        System.out.println("Faculty Name : " + entity.getFacultyName());
        return "faculty/index";
    }

    //3
    @PostMapping("/")
    public String Savefaculty(
    @RequestParam() Map<String, String> param
    ) {
        System.out.println("-------savefacultyid-------");
        System.out.println("facultyId :" + param.get("facutyId"));
        System.out.println("facultyName :" + param.get("facutyName"));
        System.out.println("-------savefacultyid-------");
        
        FacultyEntity entity = new FacultyEntity();
        if (null != param.get("facultyId")) {
            entity.setFacultyId(Integer.parseInt(param.get("facultyId")));
        }
        entity.setFacultyName(param.get("facutyName"));
        FacultyEntity result = facultyService.savefaculty(entity);
        System.out.println("facutyId :" + result.getFacultyId());
        System.out.println("facutyName :" + result.getFacultyName());

    
        return "faculty/index";
    }
    
    @GetMapping("/delete/{faculty-id}")
    public String deletefaculty(@PathVariable(name="faculty-id", required = true) Integer facultyId) {
        System.out.println("-------deletefaculty--------");
        System.out.println("-------facultyid :" + facultyId);

        System.out.println("-------getdeletefaculty-------");
        facultyService.deleteFacultyById(facultyId);
        return "faculty/index";
    }
    
    
    
    
}
