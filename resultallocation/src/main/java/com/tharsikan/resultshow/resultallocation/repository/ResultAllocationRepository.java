package com.tharsikan.resultshow.resultallocation.repository;


import com.tharsikan.resultshow.resultallocation.model.ResultAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultAllocationRepository extends JpaRepository<ResultAllocation,Long> {
    @Query("SELECT a FROM ResultAllocation a WHERE a.studentId = ?1")
    List<ResultAllocation> findByStudentId(Long studentId);
}
