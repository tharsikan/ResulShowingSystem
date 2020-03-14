package com.tharsikan.resultshow.courseallocation.repository;

import com.tharsikan.resultshow.courseallocation.model.CourseAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseAllocationRepository extends JpaRepository<CourseAllocation,Long> {
    @Query("SELECT c FROM CourseAllocation c WHERE c.batchId = ?1 AND c.courseId = ?2")
    List<CourseAllocation> findCourse(Long batchId,Long courseId);
}
