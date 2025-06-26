package com.example.ytaxi.develop.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private int bookmarkKey;
    private String userId;
    private String bookmarkTy;
    private String bookmarkId;
    private Date createdDt;
    private String createdId;
    private Date updatedDt;
    private String updatedId;
}
