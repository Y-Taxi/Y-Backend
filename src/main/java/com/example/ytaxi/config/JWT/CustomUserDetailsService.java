package com.example.ytaxi.config.JWT;

import com.example.ytaxi.develop.login.LoginServiceImpl;
import com.example.ytaxi.develop.login.dto.LoginDto;
import com.example.ytaxi.develop.login.dto.LoginUserInfoDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final LoginServiceImpl loginService;

    public CustomUserDetailsService(LoginServiceImpl loginService) {

        this.loginService = loginService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginDto parmaDto = new LoginDto();
        parmaDto.setLoginId(username);

        //DB에서 조회
        try {
            LoginDto loginDto = loginService.selectLoginDetailInfo(parmaDto);

            if (loginDto != null) {
                if("U".equals(loginDto.getRole())){
                    LoginUserInfoDto loginUserInfoDto = loginService.selectLoginUserInfo(loginDto.getLoginId());

                    loginDto.setPw(loginUserInfoDto.getUserPassword());
                }

                //UserDetails에 담아서 return하면 AutneticationManager가 검증 함
                return new CustomUserDetails(loginDto);
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
