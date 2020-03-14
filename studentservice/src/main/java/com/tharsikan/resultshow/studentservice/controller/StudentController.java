package com.tharsikan.resultshow.studentservice.controller;


import com.tharsikan.resultshow.studentservice.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping(value = "/student")
    public String getStudent(){
        return "hello";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public Student saveStudent(){
        return
    }
}
