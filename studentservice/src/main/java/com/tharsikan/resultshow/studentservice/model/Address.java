package com.tharsikan.resultshow.studentservice.model;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Data
public class Address {
    @Column(name = "houseNo")
    String houseNo;
    @Column(name = "laneName")
    String lane;
    @Column(name = "cityName")
    String city;
}
