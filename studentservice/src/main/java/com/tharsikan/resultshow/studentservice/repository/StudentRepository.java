package com.tharsikan.resultshow.studentservice.repository;

import com.tharsikan.resultshow.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
