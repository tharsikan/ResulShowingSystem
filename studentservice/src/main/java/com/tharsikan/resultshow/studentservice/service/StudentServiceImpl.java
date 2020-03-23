package com.tharsikan.resultshow.studentservice.service;

import com.tharsikan.resultshow.studentservice.model.Student;
import com.tharsikan.resultshow.studentservice.model.Telephone;
import com.tharsikan.resultshow.studentservice.nonmodel.StudentAllocation;
import com.tharsikan.resultshow.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setAllocations(getAllAllocation(id));
            return student;
        }
        return null;
    }

    @Override
    public Student saveStudent(Student student) {

        for(Telephone telephone :student.getTelephoneList()){
            telephone.setStudent(student);
        }
        student.setFullName(student.getLastName() +" "+student.getFirstName());
        ;
        System.out.println();
//        ZonedDateTime today = ZonedDateTime.parse(student.getDateOfBirth());
//        student.setDateOfBirth(today);
        return studentRepository.save(student);
    }

    @Override
    public StudentAllocation saveAllocation(Long studentId, StudentAllocation studentAllocation) {
        HttpHeaders httpheader = new HttpHeaders();
        httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<StudentAllocation> entity = new HttpEntity<StudentAllocation>(studentAllocation,httpheader);

        String url = "http://localhost:8015/"+studentId+"/allocation/";

        return restTemplate.exchange(url, HttpMethod.POST, entity, StudentAllocation.class).getBody();
    }

    @Override
    public StudentAllocation[] getAllAllocation(Long studentId) {
        HttpHeaders httpheader = new HttpHeaders();
        httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<StudentAllocation> entity = new HttpEntity<StudentAllocation>(httpheader);

        String url = "http://localhost:8015/"+studentId+"/allocation/";

        return restTemplate.exchange(url, HttpMethod.GET, entity, StudentAllocation[].class).getBody();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
    @Override
    public List<Student> getAllStudent() {
        return null;
    }


}
