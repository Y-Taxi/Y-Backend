package com.example.ytaxi.develop.test;

import com.example.ytaxi.develop.test.dto.TestDto;

import java.util.List;

public interface TestService {
    public List<TestDto> selectTest() throws Exception;
}
