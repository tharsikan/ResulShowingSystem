package com.tharsikan.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class DegreeProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degreeProgram;
    private Integer years;
    private String degreeType;
    private String degreeName;
    private String description;
    @OneToMany(mappedBy = "degreeProgram", cascade = CascadeType.ALL)
    private List<Level> levelList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch")
    @JsonIgnore
    Batch batch;
}