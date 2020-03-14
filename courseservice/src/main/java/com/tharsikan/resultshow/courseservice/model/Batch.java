package com.tharsikan.resultshow.courseservice.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
    private List<Level> levelList;

    private String startDate;
}
