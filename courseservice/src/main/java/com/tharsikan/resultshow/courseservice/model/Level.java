package com.tharsikan.resultshow.courseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String levelCode;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<Course> courseList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batchId")
    @JsonIgnore
    Batch batch;
}