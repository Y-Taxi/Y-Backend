package com.example.ytaxi.develop.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private int id;
    private String role;
    private String loginId;
    private String pw;
    private String loginOption;
    private Date createdDt;
    private String createdId;
    private Date updatedDt;
    private String updatedId;
}
