package com.tharsikan.resultshow.courseservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tharsikan.common.entity.Batch;
import com.tharsikan.common.entity.DegreeProgram;
import com.tharsikan.common.entity.Level;
import lombok.Data;

import javax.persistence.*;

@Data
public class CourseGetDto {

    private Long id;
    private String courseCode;
    private String courseTitle;
    Long degreeProgramId;
    Long batchId;
    Long levelId;

}