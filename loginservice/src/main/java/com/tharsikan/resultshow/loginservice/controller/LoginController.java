package com.tharsikan.resultshow.loginservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @RequestMapping(value="/student", method= RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @RequestMapping(value="/student/{studentId}", method= RequestMethod.GET)
    public Student saveStudent(@PathVariable Long studentId){
        return studentService.getStudent(studentId);
    }

}
