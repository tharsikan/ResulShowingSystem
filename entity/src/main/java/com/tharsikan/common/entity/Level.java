package com.tharsikan.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String level;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeProgram")
    @JsonIgnore
    DegreeProgram degreeProgram;
}