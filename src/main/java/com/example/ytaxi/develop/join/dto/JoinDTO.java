package com.example.ytaxi.develop.join.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinDTO {
    private String user_id;
    private String userLoginId;
    private String userPwd;
    private String userNm;
    private String userZipCode;
    private String userAddress;
    private String userSubAddress;
    private String userBirth;
    private String userGender;
    private String userPhone;
    private String created_dt;
    private String created_id;
    private String updated_dt;
    private String updated_id;
    private String joinType;

}
