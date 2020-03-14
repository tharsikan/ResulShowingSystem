package com.tharsikan.resultshow.studentservice.service;

import com.tharsikan.resultshow.studentservice.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudent(Long id);
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    Student updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
