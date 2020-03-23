package com.tharsikan.resultshow.courseservice.service;

import com.tharsikan.common.entity.Batch;
import com.tharsikan.common.entity.DegreeProgram;
import com.tharsikan.common.entity.Level;
import com.tharsikan.resultshow.courseservice.repository.BatchRepository;
import com.tharsikan.resultshow.courseservice.repository.DegreeProgrameRepository;
import com.tharsikan.resultshow.courseservice.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    BatchRepository batchRepository;
    @Autowired
    DegreeProgrameRepository degreeProgrameRepository;


    @Override
    public Batch saveBatch(Batch batch) {
        return batchRepository.save(batch);
    }
    @Override
    public List<Batch> getAllBatch() {
        return batchRepository.findAll();
    }

    @Override
    public DegreeProgram saveDegreeProgram(DegreeProgram degreeProgram, Long batchId) {
        Optional<Batch> optionalBatch = batchRepository.findById(batchId);
        if(optionalBatch.isPresent()){
            degreeProgram.setBatch(optionalBatch.get());
        }
        return degreeProgrameRepository.save(degreeProgram);
    }

    @Override
    public List<DegreeProgram> getDegreePrograms(Long batchId) {
        Optional<Batch> optionalBatch = batchRepository.findById(batchId);
        if(optionalBatch.isPresent()){
            return optionalBatch.get().getDegreeProgramList();
        }
        else return null;
    }


    @Override
    public Level saveLevel(Level level, Long degreeId) {
        Optional<DegreeProgram> degreeProgramOptional = degreeProgrameRepository.findById(degreeId);
        if(degreeProgramOptional.isPresent()){
            level.setDegreeProgram(degreeProgramOptional.get());
        }
        System.out.println(degreeProgramOptional.get().getDegreeProgram());
        return levelRepository.save(level);
    }

    @Override
    public List<Level> getLeves(Long degreeId) {
        Optional<DegreeProgram> optionalDegreeProgram = degreeProgrameRepository.findById(degreeId);
        if(optionalDegreeProgram.isPresent()){
            return optionalDegreeProgram.get().getLevelList();
        }
        else return null;
    }

}
