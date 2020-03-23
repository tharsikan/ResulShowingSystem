package com.tharsikan.resultshow.studnetallocation.service;

import com.tharsikan.resultshow.studnetallocation.model.StudentAllocation;

import java.util.List;

public interface StudentAllocationService {
    StudentAllocation saveStudentAllocation(StudentAllocation studentAllocation);
    List<StudentAllocation> getStudentAllocation(Long StudentId);
}
