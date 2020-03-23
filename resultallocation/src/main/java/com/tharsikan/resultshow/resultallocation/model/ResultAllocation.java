package com.tharsikan.resultshow.resultallocation.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class ResultAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    Long courseId;
    Long studentId;
    Long resultId;
}