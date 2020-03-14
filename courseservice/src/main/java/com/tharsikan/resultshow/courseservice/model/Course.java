package com.tharsikan.resultshow.courseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "levelId")
    @JsonIgnore
    Level level;
}