package com.tharsikan.resultshow.courseservice.repository;

import com.tharsikan.resultshow.courseservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("SELECT c FROM Course c WHERE c.levelId = ?1 ")
    List<Course> findCourse(Long levelId);

}
