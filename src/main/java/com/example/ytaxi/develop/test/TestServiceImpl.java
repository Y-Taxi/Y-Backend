package com.example.ytaxi.develop.test;

import com.example.ytaxi.develop.test.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDaO testDaO;

    @Override
    public List<TestDto> selectTest() throws Exception {
        List<TestDto> vos = testDaO.selectTest();

        return vos;
    }
}
