package com.tharsikan.resultshow.studentservice.service;

import com.tharsikan.resultshow.studentservice.model.Student;
import com.tharsikan.resultshow.studentservice.nonmodel.StudentAllocation;

import java.util.List;

public interface StudentService {
    Student getStudent(Long id);
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    StudentAllocation saveAllocation(Long studentId, StudentAllocation studentAllocation);
    StudentAllocation[] getAllAllocation(Long studentId);
    Student updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
