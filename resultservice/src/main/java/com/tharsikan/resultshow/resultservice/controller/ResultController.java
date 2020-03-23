package com.tharsikan.resultshow.resultservice.controller;


import com.tharsikan.resultshow.resultservice.model.Result;
import com.tharsikan.resultshow.resultservice.nonmodel.ResultAllocation;
import com.tharsikan.resultshow.resultservice.service.ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {

    @Autowired
    ResultServiceImpl rsultRepository;

    @RequestMapping(value="student/{studentId}/course/{courseId}/result", method= RequestMethod.POST)
    public Result saveResult(@RequestBody Result student,@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId){
        return rsultRepository.saveAllocationResult(student,studentId,courseId);
    }

    @RequestMapping(value="/result/{studentId}", method= RequestMethod.GET)
    public Result saveResult(@PathVariable Long studentId){
        return rsultRepository.getResult(studentId);
    }

    @RequestMapping(value="/result/{studentId}/allocation", method= RequestMethod.POST)
    public ResultAllocation saveResultAllocation(@PathVariable Long studentId, @RequestBody ResultAllocation studentAllocation){
        return rsultRepository.saveResultAllocation(studentAllocation);
    }

    @RequestMapping(value="/result/{studentId}/allocation", method= RequestMethod.GET)
    public ResultAllocation getResultAllocation(@PathVariable Long studentId){
        return rsultRepository.getResultAllocation(studentId);
    }

}
