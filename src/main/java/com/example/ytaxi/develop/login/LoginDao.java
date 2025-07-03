package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {
    @Autowired
    private SqlSession sqlSession;

    public Integer selectLoginCnt(LoginDto loginDto) {
        return sqlSession.selectOne("com.login.mapper.LoginMapper.selectLoginCnt", loginDto);
    }
}
