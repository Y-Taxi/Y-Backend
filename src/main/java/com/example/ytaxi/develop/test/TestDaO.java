package com.example.ytaxi.develop.test;

import com.example.ytaxi.develop.test.dto.TestDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaO {

    @Autowired
    private SqlSession sqlSession;

    public List<TestDto> selectTest() {
        return sqlSession.selectList("com.test.mapper.TestMapper.selectTest");
    }
}
