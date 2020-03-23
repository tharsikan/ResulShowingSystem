package com.tharsikan.resultshow.resultallocation.controller;

import com.tharsikan.resultshow.resultallocation.model.ResultAllocation;
import com.tharsikan.resultshow.resultallocation.service.ResultAllocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultAllocationController {

    @Autowired
    ResultAllocationServiceImpl studentAllocationService;

    @RequestMapping(value = "/{studentId}/allocation",method = RequestMethod.POST)
    public ResultAllocation saveAllocation(@RequestBody ResultAllocation studentAllocation, @PathVariable Long studentId){
        studentAllocation.setStudentId(studentId);
        return  studentAllocationService.saveResultAllocation(studentAllocation);
    }

    @RequestMapping(value = "/{studentId}/allocation",method = RequestMethod.GET)
    public List<ResultAllocation> getAllocation(@PathVariable Long studentId){
        return studentAllocationService.getStudentResultAllocation(studentId);
    }
}