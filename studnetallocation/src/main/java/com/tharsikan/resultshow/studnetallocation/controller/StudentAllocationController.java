package com.tharsikan.resultshow.studnetallocation.controller;

import com.tharsikan.resultshow.studnetallocation.model.StudentAllocation;
import com.tharsikan.resultshow.studnetallocation.service.StudentAllocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentAllocationController {

    @Autowired
    StudentAllocationServiceImpl studentAllocationService;

    @RequestMapping(value = "/{studentId}/allocation",method = RequestMethod.POST)
    public StudentAllocation saveAllocation(@RequestBody StudentAllocation studentAllocation, @PathVariable Long studentId){
        studentAllocation.setStudentId(studentId);
        return  studentAllocationService.saveStudentAllocation(studentAllocation);
    }

    @RequestMapping(value = "/{studentId}/allocation",method = RequestMethod.GET)
    public List<StudentAllocation> getAllocation(@PathVariable Long studentId){
        return studentAllocationService.getStudentAllocation(studentId);
    }
}