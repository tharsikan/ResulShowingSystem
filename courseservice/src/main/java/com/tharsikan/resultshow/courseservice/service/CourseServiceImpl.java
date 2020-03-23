package com.tharsikan.resultshow.courseservice.service;

import com.tharsikan.resultshow.courseservice.dto.CourseGetDto;
import com.tharsikan.resultshow.courseservice.entitymapmodel.CourseDtoToCourse;
import com.tharsikan.resultshow.courseservice.model.Course;
import com.tharsikan.resultshow.courseservice.repository.BatchRepository;
import com.tharsikan.resultshow.courseservice.repository.CourseRepository;
import com.tharsikan.resultshow.courseservice.repository.DegreeProgrameRepository;
import com.tharsikan.resultshow.courseservice.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseDtoToCourse courseDtoToCourse;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    @Override
    public Course getCourse(Long courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if(optionalCourse.isPresent()){
            return optionalCourse.get();
        }
        else return null;
    }

    @Override
    public Course getOneCourse(Long batchId, Long degreeId, Long levelId, Long courseId) {
        System.out.println("Hlelo");
        return null;
    }

    @Override
    public List<Course> getLevelCourses(Long levelId) {
        return courseRepository.findCourse(levelId);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
