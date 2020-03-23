package com.tharsikan.resultshow.studentservice.nonmodel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class StudentAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long batchId;
    private Long degreeProgramId;
    private Long levelId;
    private Long studentId;

}
