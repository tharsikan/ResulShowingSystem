package com.tharsikan.resultshow.studentservice.controller;


import com.tharsikan.resultshow.studentservice.model.Student;
import com.tharsikan.resultshow.studentservice.nonmodel.StudentAllocation;
import com.tharsikan.resultshow.studentservice.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @RequestMapping(value="/student", method= RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @RequestMapping(value="/student/{studentId}", method= RequestMethod.GET)
    public Student saveStudent(@PathVariable Long studentId){
        return studentService.getStudent(studentId);
    }

    @RequestMapping(value="/student/{studentId}/allocation", method= RequestMethod.POST)
    public StudentAllocation saveStudentAllocation(@PathVariable Long studentId, @RequestBody StudentAllocation studentAllocation){
        return studentService.saveAllocation(studentId,studentAllocation);
    }

    @RequestMapping(value="/student/{studentId}/allocation", method= RequestMethod.GET)
    public StudentAllocation[] getStudentAllocation(@PathVariable Long studentId){
        return studentService.getAllAllocation(studentId);
    }

}
