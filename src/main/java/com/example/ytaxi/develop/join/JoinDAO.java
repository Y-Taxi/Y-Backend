package com.example.ytaxi.develop.join;

import com.example.ytaxi.develop.join.dto.JoinDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JoinDAO {

    @Autowired
    private SqlSession sqlSession;

    public int joinUser(JoinDTO joinDTO) {
        return sqlSession.insert( "USER_ADD", joinDTO);
    }
}
