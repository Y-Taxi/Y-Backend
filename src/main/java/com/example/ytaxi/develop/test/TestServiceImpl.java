package com.example.ytaxi.develop.test;

import com.example.ytaxi.develop.login.dto.LoginDto;
import com.example.ytaxi.develop.test.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDaO testDaO;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public TestServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<TestDto> selectTest() throws Exception {
        List<TestDto> vos = testDaO.selectTest();

        return vos;
    }

    @Override
    public Integer insertUserPwDrm(LoginDto loginDto) throws Exception {
         String pw = loginDto.getPw();
         loginDto.setPw(bCryptPasswordEncoder.encode(pw));

         int result = testDaO.insertUserPwDrm(loginDto);
         result += testDaO.insertUserPwDrm2(loginDto);

        return result;
    }
}
