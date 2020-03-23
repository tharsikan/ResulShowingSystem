package com.tharsikan.resultshow.resultservice.model;

import com.tharsikan.resultshow.resultservice.nonmodel.ResultAllocation;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Float earnedGpv;
    private String grade;
    private Float marks;
    private Float credits;
    private String academicYear;
    @Transient
    private ResultAllocation resultAllocation;
}
