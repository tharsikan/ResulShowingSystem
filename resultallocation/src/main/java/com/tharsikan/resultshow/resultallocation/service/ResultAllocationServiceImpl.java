package com.tharsikan.resultshow.resultallocation.service;

import com.tharsikan.resultshow.resultallocation.model.ResultAllocation;
import com.tharsikan.resultshow.resultallocation.repository.ResultAllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultAllocationServiceImpl implements ResultAllocationService {

    @Autowired
    ResultAllocationRepository resultAllocationRepository;

    @Override
    public ResultAllocation saveResultAllocation(ResultAllocation resultAllocation) {
        return resultAllocationRepository.save(resultAllocation);
    }

    @Override
    public List<ResultAllocation> getStudentResultAllocation(Long StudentId) {
        return resultAllocationRepository.findByStudentId(StudentId);
    }
}
