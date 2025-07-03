package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDto;

public interface LoginService {
    public Integer selectLoginCnt(LoginDto loginDto) throws Exception;
}
