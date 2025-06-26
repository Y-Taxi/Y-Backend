package com.example.ytaxi.develop.test;

import com.example.ytaxi.develop.test.dto.TestDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TestServiceImpl testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> selectMember(HttpServletRequest request) throws Exception {
        List<TestDto> result = testService.selectTest();

        return ResponseEntity.ok(result);
    }
}
