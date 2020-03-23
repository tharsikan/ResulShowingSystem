package com.tharsikan.resultshow.studentservice.model;

import com.tharsikan.common.entity.Batch;
import com.tharsikan.common.entity.DegreeProgram;
import com.tharsikan.common.entity.Level;
import com.tharsikan.resultshow.studentservice.nonmodel.StudentAllocation;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String indexNo;
    private String registration;

    private String fullName;
    private String firstName;
    private String lastName;

    private String gender;
    private String subjectCombination;
    private String nicNo;
    private LocalDate dateOfBirth;          // in jpa 2.2.. @Temporal no need, it will map to DATE

    @Transient
    private StudentAllocation[] allocations;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Telephone> telephoneList;

    private String eMail;
}
