package com.tharsikan.resultshow.studnetallocation.repository;

import com.tharsikan.resultshow.studnetallocation.model.StudentAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentAllocationRepository extends JpaRepository<StudentAllocation,Long> {
    @Query("SELECT a FROM StudentAllocation a WHERE a.studentId = ?1")
    List<StudentAllocation> findByEmployee_id(Long studentId);
}
