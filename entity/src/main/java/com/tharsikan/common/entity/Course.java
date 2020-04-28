package com.tharsikan.common.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private String courseTitle;
    Long degreeProgramId;
    Long batchId;
    Long levelId;
    Long gpa;
}