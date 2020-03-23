package com.tharsikan.resultshow.studnetallocation.service;

import com.tharsikan.resultshow.studnetallocation.model.StudentAllocation;
import com.tharsikan.resultshow.studnetallocation.repository.StudentAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAllocationServiceImpl implements StudentAllocationService {

    @Autowired
    StudentAllocationRepository studentAllocationRepository;


    @Override
    public StudentAllocation saveStudentAllocation(StudentAllocation studentAllocation) {
        return studentAllocationRepository.save(studentAllocation);
    }

    @Override
    public List<StudentAllocation> getStudentAllocation(Long StudentId) {
        return studentAllocationRepository.findByEmployee_id(StudentId);
    }

}