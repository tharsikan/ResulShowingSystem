package com.tharsikan.resultshow.courseservice.controller;

import com.tharsikan.common.entity.Batch;
import com.tharsikan.common.entity.DegreeProgram;
import com.tharsikan.common.entity.Level;
import com.tharsikan.resultshow.courseservice.dto.CourseGetDto;
import com.tharsikan.resultshow.courseservice.model.Course;
import com.tharsikan.resultshow.courseservice.service.CourseServiceImpl;
import com.tharsikan.resultshow.courseservice.service.LevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class LevelController {
    @Autowired
    LevelServiceImpl levelService;

    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    public Batch saveBatch(@RequestBody Batch batch){
        return levelService.saveBatch(batch);
    }
    @RequestMapping(value = "/batch", method = RequestMethod.GET)
    public List<Batch> getAllBatch(){
        return levelService.getAllBatch();
    }
    @RequestMapping(value = "batch/{batchId}/degreeProgram", method = RequestMethod.POST)
    public DegreeProgram saveBatch(@RequestBody DegreeProgram degreeProgram, @PathVariable("batchId") Long batchId){
        return levelService.saveDegreeProgram(degreeProgram,batchId);
    }
    @RequestMapping(value = "batch/{batchId}/degreeProgram", method = RequestMethod.GET)
    public List<DegreeProgram> getDegreeProgram(@PathVariable("batchId") Long batchId){
        return levelService.getDegreePrograms(batchId);
    }

    @RequestMapping(value = "degreeProgram/{degreeId}/level", method = RequestMethod.POST)
    public Level saveBatch(@RequestBody Level level,@PathVariable("degreeId") Long degreeId){
        return levelService.saveLevel(level,degreeId);
    }
    @RequestMapping(value = "degreeProgram/{degreeId}/level", method = RequestMethod.GET)
    public List<Level> getLevels(@PathVariable("degreeId") Long degreeId){
        return levelService.getLeves(degreeId);
    }
}
