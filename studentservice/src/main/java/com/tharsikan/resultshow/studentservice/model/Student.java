package com.tharsikan.resultshow.studentservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String indexNo;
    private String batchNo;
    private String currentLevel;
    private String registration;
    private String fullName;
    private String gender;
    private String degreeProgram;
    private String subjectCombination;
    private String nicNo;
    private String dateOfBirth;
    private String permanentAddress;
    private String temporaryAddress;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Telephone> telephoneList;

    private String eMail;

}
