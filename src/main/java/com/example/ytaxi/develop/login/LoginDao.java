package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDriverInfoDto;
import com.example.ytaxi.develop.login.dto.LoginDto;
import com.example.ytaxi.develop.login.dto.LoginUserInfoDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
    @Autowired
    private SqlSession sqlSession;

    /**
     * 로그인 ID/PW 일치 확인(개수)
     * @param loginDto
     * @return
     */
    public Integer selectLoginCnt(LoginDto loginDto) {
        return sqlSession.selectOne("com.login.mapper.LoginMapper.selectLoginCnt", loginDto);
    }

    /**
     * 로그인 상세 정보 조회
     * @param loginDto
     * @return
     */
    public LoginDto selectLoginDetailInfo(LoginDto loginDto) {
        return sqlSession.selectOne("com.login.mapper.LoginMapper.selectLoginDetailInfo", loginDto);
    }

    /**
     * 로그인 사용자(U) 정보 조회
     * @param userId
     * @return
     */
    public LoginUserInfoDto selectLoginUserInfo(String userId) {
        return sqlSession.selectOne("com.login.mapper.LoginMapper.selectLoginUserInfo", userId);
    }

    /**
     * 로그인 택시기사(D) 정보 조회
     * @param driverId
     * @return
     */
    public LoginDriverInfoDto selectLoginDriverInfo(String driverId) {
        return sqlSession.selectOne("com.login.mapper.LoginMapper.selectLoginDriverInfo", driverId);
    }
}
