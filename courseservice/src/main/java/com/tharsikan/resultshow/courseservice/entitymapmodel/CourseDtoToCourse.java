package com.tharsikan.resultshow.courseservice.entitymapmodel;


import com.tharsikan.resultshow.courseservice.dto.CourseGetDto;
import com.tharsikan.resultshow.courseservice.model.Course;
import com.tharsikan.resultshow.courseservice.repository.BatchRepository;
import com.tharsikan.resultshow.courseservice.repository.DegreeProgrameRepository;
import com.tharsikan.resultshow.courseservice.repository.LevelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDtoToCourse {

    @Autowired
    BatchRepository batchRepository;
    @Autowired
    DegreeProgrameRepository degreeProgrameRepository;
    @Autowired
    LevelRepository levelRepository;

    ModelMapper modelMapper = new ModelMapper();

    public CourseGetDto convertToDto(Course course) {
        CourseGetDto courseGetDto = modelMapper.map(course, CourseGetDto.class);
        courseGetDto.setCourseCode(course.getCourseCode());
        return courseGetDto;
    }
//    public Course convertToEntity(CourseGetDto courseGetDto) {
//        Course course = modelMapper.map(courseGetDto, Course.class);
//        course.setBatch(batchRepository.findById(courseGetDto.getBatchId()).get());
//        course.setDegreeProgram(degreeProgrameRepository.findById(courseGetDto.getDegreeProgramId()).get());
//        course.setLevel(levelRepository.findById(courseGetDto.getLevelId()).get());
//        return course;
//    }

}
