package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDriverInfoDto;
import com.example.ytaxi.develop.login.dto.LoginDto;
import com.example.ytaxi.develop.login.dto.LoginUserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    /**
     * 로그인 ID/PW 일치 확인(개수)
     * @param loginDto
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer selectLoginCnt(LoginDto loginDto) throws Exception {
        int cnt = loginDao.selectLoginCnt(loginDto);

        return cnt;
    }

    /**
     * 로그인 상세 정보
     * @param loginDto
     * @return
     * @throws Exception
     */
    @Override
    public LoginDto selectLoginDetailInfo(LoginDto loginDto) throws Exception {
        return loginDao.selectLoginDetailInfo(loginDto);
    }

    /**
     * 로그인 사용자(U) 정보 조회
     * @param userId
     * @return LoginUserInfoDto
     * @throws Exception
     */
    @Override
    public LoginUserInfoDto selectLoginUserInfo(String userId) throws Exception {
        return loginDao.selectLoginUserInfo(userId);
    }

    /**
     * 로그인 택시기사(D) 정보 조회
     * @param driverId
     * @return
     * @throws Exception
     */
    @Override
    public LoginDriverInfoDto selectLoginDriverInfo(String driverId) throws Exception {
        return loginDao.selectLoginDriverInfo(driverId);
    }
}
