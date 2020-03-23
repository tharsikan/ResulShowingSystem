package com.tharsikan.resultshow.resultservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.tharsikan.resultshow.resultservice.model")
public class ResultserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResultserviceApplication.class, args);
	}

}