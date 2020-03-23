package com.tharsikan.resultshow.studnetallocation.model;

import lombok.Data;
import org.hibernate.engine.jdbc.batch.spi.Batch;

import javax.persistence.*;
import java.util.List;

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
