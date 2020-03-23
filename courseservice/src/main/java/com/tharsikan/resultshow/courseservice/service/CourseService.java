package com.tharsikan.resultshow.courseservice.service;

import com.tharsikan.resultshow.courseservice.dto.CourseGetDto;
import com.tharsikan.resultshow.courseservice.model.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    List<Course> getAllCourse();
    Course getCourse(Long courseId);
    Course getOneCourse(Long batchId, Long degreeId, Long levelId, Long courseId);
    List<Course> getLevelCourses(Long levelId);
}
