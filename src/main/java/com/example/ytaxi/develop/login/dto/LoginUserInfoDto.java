package com.example.ytaxi.develop.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfoDto {
    private String role;
    private String userId;
    private String userNm;
    private String userPhone;
    private String userZipcode;
    private String userAddr;
    private String userDetailAddr;
    private Date createdDt;
    private String createdId;
    private Date updatedDt;
    private String updatedId;
}
