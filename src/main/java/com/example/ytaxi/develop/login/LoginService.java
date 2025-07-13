package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDriverInfoDto;
import com.example.ytaxi.develop.login.dto.LoginDto;
import com.example.ytaxi.develop.login.dto.LoginUserInfoDto;

public interface LoginService {
    /**
     * 로그인 ID/PW 일치 확인(개수)
     * @param loginDto
     * @return Integer
     * @throws Exception
     */
    public Integer selectLoginCnt(LoginDto loginDto) throws Exception;

    /**
     * 로그인 상세 정보
     * @param loginDto
     * @return
     * @throws Exception
     */
    public LoginDto selectLoginDetailInfo(LoginDto loginDto) throws Exception;

    /**
     * 로그인 사용자(U) 정보 조회
     * @param userId
     * @return LoginUserInfoDto
     * @throws Exception
     */
    public LoginUserInfoDto selectLoginUserInfo(String userId) throws Exception;

    /**
     * 로그인 택시기사(D) 정보 조회
     * @param driverId
     * @return
     * @throws Exception
     */
    public LoginDriverInfoDto selectLoginDriverInfo(String driverId) throws Exception;
}
