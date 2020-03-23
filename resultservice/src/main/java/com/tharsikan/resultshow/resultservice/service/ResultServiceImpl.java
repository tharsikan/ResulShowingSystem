package com.tharsikan.resultshow.resultservice.service;

import com.tharsikan.resultshow.resultservice.model.Result;
import com.tharsikan.resultshow.resultservice.nonmodel.ResultAllocation;
import com.tharsikan.resultshow.resultservice.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl extends Calculations implements  ResultService{
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ResultRepository resultRepository;

    @Override
    public Result getResult(Long id) {
        Optional<Result> optionalResult = resultRepository.findById(id);
        if(optionalResult.isPresent()) {
            Result result = optionalResult.get();
            result.setResultAllocation(getResultAllocation(id));
            return result;
        }
        return null;
    }

    public Result saveAllocationResult(Result result,Long studentId,Long courseId){

        Result result1 = saveResult(result);

        ResultAllocation resultAllocation = new ResultAllocation();
        resultAllocation.setCourseId(courseId);
        resultAllocation.setStudentId(studentId);
        resultAllocation.setResultId(result1.getId());
        ResultAllocation resultAllocation1 = saveResultAllocation(resultAllocation);

        result1.setResultAllocation(resultAllocation1);
        return result1;
    }

    @Override
    public Result saveResult(Result result) {
        result.setGrade(gradeCalculation(result.getMarks()));
        result.setEarnedGpv(earnedGpvCalculation(result.getCredits()));
        return resultRepository.save(result);
    }

    @Override
    public ResultAllocation saveResultAllocation(ResultAllocation resultAllocation) {
        HttpHeaders httpheader = new HttpHeaders();
        httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ResultAllocation> entity = new HttpEntity<ResultAllocation>(resultAllocation,httpheader);
        Long studentId = resultAllocation.getStudentId();

        String url = "http://localhost:8017/"+studentId+"/allocation/";

        return restTemplate.exchange(url, HttpMethod.POST, entity, ResultAllocation.class).getBody();
    }

    @Override
    public ResultAllocation getResultAllocation(Long studentId) {
        HttpHeaders httpheader = new HttpHeaders();
        httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ResultAllocation> entity = new HttpEntity<ResultAllocation>(httpheader);

        String url = "http://localhost:8017/"+studentId+"/allocation/";

        return restTemplate.exchange(url, HttpMethod.GET, entity, ResultAllocation.class).getBody();
    }

    @Override
    public Result updateResult(Long id, Result student) {
        return null;
    }

    @Override
    public void deleteResult(Long id) {

    }
    @Override
    public List<Result> getAllResult() {

        return null;
    }

}
