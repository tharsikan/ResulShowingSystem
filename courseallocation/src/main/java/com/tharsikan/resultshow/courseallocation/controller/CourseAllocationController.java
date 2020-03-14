package com.tharsikan.resultshow.courseallocation.controller;

import com.tharsikan.resultshow.courseallocation.model.CourseAllocation;
import com.tharsikan.resultshow.courseallocation.service.CourseAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseAllocationController {

    @Autowired
    CourseAllocationService courseAllocationService;

    @RequestMapping(value = "/{batchId}/allocation",method = RequestMethod.POST)
    public CourseAllocation saveAllocation(@RequestBody CourseAllocation courseAllocation, @PathVariable Long batchId, @RequestParam(value = "id") Long levelId){
        courseAllocation.setBatchId(batchId);
        courseAllocation.setLevelId(levelId);
        return  courseAllocationService.saveCourseAllocation(courseAllocation);
    }

    @RequestMapping(value = "/{batchId}/allocation",method = RequestMethod.GET)
    public List<CourseAllocation> getAllocation(@PathVariable Long batchId, @RequestParam(value = "id") Long levelId){
        return courseAllocationService.getCourseAllocation(batchId,levelId);
    }
}
