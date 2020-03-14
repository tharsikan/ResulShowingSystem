package com.tharsikan.resultshow.courseallocation.service;

import com.tharsikan.resultshow.courseallocation.model.CourseAllocation;

import java.util.List;

public interface CourseAllocationService {
    public CourseAllocation saveCourseAllocation(CourseAllocation courseAllocation);
    public List<CourseAllocation> getCourseAllocation(Long batch_id,Long level_id);
}
