package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping(value = "/loginResult", method = RequestMethod.POST)
    public ResponseEntity<?> selectLoginCnt(HttpServletRequest request, @RequestBody LoginDto loginDto) throws Exception {
        int result = 0; // 1: 성공, 0: 실패
        int cnt = 0; //로그인 아이디/비번 일치 개수

        cnt = loginService.selectLoginCnt(loginDto);

        if(cnt > 0){
            result = 1;
        }else{
            result = 0;
        }

        return ResponseEntity.ok(result);
    }
}
