package com.tharsikan.resultshow.courseallocation.service;

import com.tharsikan.resultshow.courseallocation.model.CourseAllocation;
import com.tharsikan.resultshow.courseallocation.repository.CourseAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAllocationServiceImpl implements CourseAllocationService {
    @Autowired
    CourseAllocationRepository courseAllocationRepository;


    @Override
    public CourseAllocation saveCourseAllocation(CourseAllocation courseAllocation) {
        return courseAllocationRepository.save(courseAllocation);
    }

    @Override
    public List<CourseAllocation> getCourseAllocation(Long batchId, Long levelId) {
        return courseAllocationRepository.findCourse(batchId, levelId);
    }
}
