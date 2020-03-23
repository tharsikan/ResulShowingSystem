package com.tharsikan.resultshow.courseservice.service;

import com.tharsikan.common.entity.Batch;
import com.tharsikan.common.entity.DegreeProgram;
import com.tharsikan.common.entity.Level;

import java.util.List;

public interface LevelService {
    Batch saveBatch(Batch batch);
    List<Batch> getAllBatch();
    DegreeProgram saveDegreeProgram(DegreeProgram degreeProgram,Long batchId);
    List<DegreeProgram> getDegreePrograms(Long batchId);
    Level saveLevel(Level level,Long degreeId);
    List<Level> getLeves(Long degreeId);
}
