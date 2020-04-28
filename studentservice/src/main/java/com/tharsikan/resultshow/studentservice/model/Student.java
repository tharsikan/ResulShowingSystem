package com.tharsikan.resultshow.studentservice.model;

import com.tharsikan.common.entity.Batch;
import com.tharsikan.common.entity.DegreeProgram;
import com.tharsikan.common.entity.Level;
import com.tharsikan.resultshow.studentservice.nonmodel.StudentAllocation;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
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
   // private LocalDate dateOfBirth;          // in jpa 2.2.. @Temporal no need(map to DATE), no need additional mapping
    private ZonedDateTime dateOfBirth;          // this gonna mapping to TIMESTAMP like LocalDateTime (not consider ZoneInfo, just SystemDefaultZone)
                                                // so we need to tell the ZoneInfo in application.yml

    @Transient
    private StudentAllocation[] allocations;

//    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNo", column = @Column(name = "houseNo") ),
            @AttributeOverride(name = "lane", column = @Column(name = "laneName") ),
            @AttributeOverride(name = "city", column = @Column(name = "cityName") )
    })
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telephone> telephoneList;

    private String eMail;
}
