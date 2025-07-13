package com.example.ytaxi.develop.login;

import com.example.ytaxi.develop.login.dto.LoginDriverInfoDto;
import com.example.ytaxi.develop.login.dto.LoginDto;
import com.example.ytaxi.develop.login.dto.LoginUserInfoDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(value = "/login")
@Slf4j
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    /**
     * 로그인 성공 결과 return
     * @param request
     * @param loginDto
     * @return 로그인 성공 여부 1: 성공, 0: 실패
     * @throws Exception
     */
    @RequestMapping(value = "/loginResult", method = RequestMethod.POST)
    public Integer selectLoginCnt(HttpServletRequest request, @RequestBody LoginDto loginDto) throws Exception {
        int result = 0; // 1: 성공, 0: 실패
        int cnt = 0; //로그인 아이디/비번 일치 개수

        cnt = loginService.selectLoginCnt(loginDto);

        if(cnt > 0){
            result = 1;
        }else{
            result = 0;
        }

        return result;
    }

    /**
     * 로그인 사용자(U) 정보 return
     * @param request
     * @param loginDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginUserInfo", method = RequestMethod.POST)
    public LoginUserInfoDto selectLoginUserInfo(HttpServletRequest request, @RequestBody LoginDto loginDto) throws Exception {
        int cnt = 0;
        LoginUserInfoDto userInfoDto = null;

        cnt = loginService.selectLoginCnt(loginDto);

        if(cnt > 0) {
            userInfoDto = loginService.selectLoginUserInfo(loginDto.getLoginId());

            if (userInfoDto == null) {
                throw new Exception(); //사용자 정보가 존재하지 않습니다.
            }
        } else{
            throw new Exception(); //사용자 정보가 존재하지 않습니다.
        }

        return userInfoDto;
    }

    /**
     * 로그인 택시기사(D) 정보 return
     * @param request
     * @param loginDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/loginDriverInfo", method = RequestMethod.POST)
    public LoginDriverInfoDto selectLoginDriverInfo(HttpServletRequest request, @RequestBody LoginDto loginDto) throws Exception {
        int cnt = 0;
        LoginDriverInfoDto driverInfoDto = null;

        cnt = loginService.selectLoginCnt(loginDto);

        if(cnt > 0) {
            driverInfoDto = loginService.selectLoginDriverInfo(loginDto.getLoginId());

            if (driverInfoDto == null) {
                throw new Exception(); //사용자 정보가 존재하지 않습니다.
            }
        } else{
            throw new Exception(); //사용자 정보가 존재하지 않습니다.
        }

        return driverInfoDto;
    }
}
