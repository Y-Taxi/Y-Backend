package com.example.ytaxi.develop.join;

import com.example.ytaxi.develop.join.dto.JoinDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class JoinServiceImpl implements JoinService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JoinDAO joinDAO;

    @Override
    public int joinUser(JoinDTO joinDTO) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();
        int result = 0;
        // 아이디 중복 체크

        // 비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(joinDTO.getUserPwd());
        joinDTO.setUserPwd(encryptedPassword);
        result = joinDAO.joinUser(joinDTO);

        if (result > 0) {
            resultMap.put("status", "success");
            resultMap.put("message", "회원가입 성공");
        }

        return result;
    }
}
