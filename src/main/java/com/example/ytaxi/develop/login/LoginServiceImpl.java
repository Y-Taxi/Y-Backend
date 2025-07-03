package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Integer selectLoginCnt(LoginDto loginDto) throws Exception {
        int cnt = loginDao.selectLoginCnt(loginDto);

        return cnt;
    }
}
