package com.tharsikan.resultshow.resultservice.repository;

import com.tharsikan.resultshow.resultservice.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result,Long> {
}
