package com.tharsikan.resultshow.courseservice.controller;


import com.tharsikan.common.entity.Batch;
import com.tharsikan.resultshow.courseservice.dto.CourseGetDto;
import com.tharsikan.resultshow.courseservice.model.Course;
import com.tharsikan.resultshow.courseservice.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CourseController {
    @Autowired
    CourseServiceImpl courseService;

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public Course saveCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }
    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable("courseId") Long courseId){
        return courseService.getCourse(courseId);
    }
    @RequestMapping(value = "/batch/{batchId}/degree/{degreeId}/level/{levelId}/course/{courseId}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable("batchId") Long batchId, @PathVariable("degreeId") Long degreeId, @PathVariable("levelId") Long levelId, @PathVariable("courseId") Long courseId){
        return null;// courseService.getOneCourse(batchId, degreeId, levelId, courseId);
    }
    @RequestMapping(value = "/level/{levelId}/course", method = RequestMethod.GET)
    public List<Course> getLevelCourse(@PathVariable("levelId") Long levelId){
        return courseService.getLevelCourses(levelId);
    }
}
