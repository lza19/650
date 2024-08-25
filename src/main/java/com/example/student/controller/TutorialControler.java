package com.example.student.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class TutorialControler {

    @GetMapping("/")
    public String getTutorial(
        @RequestParam( name = "id", required = false, defaultValue = "0") Integer id
    ) {
        System.out.println("-----------get-----------");
        System.out.println("ID: " +id);
        return "tem";
    }

    @GetMapping("/Ex2/{id}")
    public String name(
        @PathVariable( name= "id" ) Integer id
    ){
        System.out.println("-----------get/Ex2-----------");
        System.out.println("ID: " +id);
        return "index";
    }

    @PostMapping("/Ex3")
    public String postMethodName(
        @RequestParam() Map<String, String> param
    ) {
        System.out.println("-----------get/Ex3-----------");
        System.out.println(param.get("id"));
        System.out.println(param.get("code"));
        return "index";
    }

    
    



    
}
