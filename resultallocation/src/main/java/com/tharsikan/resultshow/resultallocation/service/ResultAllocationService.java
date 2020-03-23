package com.tharsikan.resultshow.resultallocation.service;

import com.tharsikan.resultshow.resultallocation.model.ResultAllocation;

import java.util.List;

public interface ResultAllocationService {
    ResultAllocation saveResultAllocation(ResultAllocation resultAllocation);
    List<ResultAllocation> getStudentResultAllocation(Long StudentId);
}
