package com.tharsikan.resultshow.resultservice.service;

import com.tharsikan.resultshow.resultservice.model.Result;
import com.tharsikan.resultshow.resultservice.nonmodel.ResultAllocation;

import java.util.List;

public interface ResultService {
    Result saveAllocationResult(Result result,Long studentId,Long courseId);
    Result getResult(Long id);
    List<Result> getAllResult();
    Result saveResult(Result result);
    ResultAllocation saveResultAllocation(ResultAllocation resultAllocation);
    ResultAllocation getResultAllocation(Long studentId);
    Result updateResult(Long id, Result result);
    void deleteResult(Long id);
}
