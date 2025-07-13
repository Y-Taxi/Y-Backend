package com.example.ytaxi.develop.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDriverInfoDto {
    private String role;
    private String driverId;
    private String driverNm;
    private String driverPhone;
    private String businessNumber;
    private String taxiNumber;
    private Date createdDt;
    private String createdId;
    private Date updatedDt;
    private String updatedId;
}
