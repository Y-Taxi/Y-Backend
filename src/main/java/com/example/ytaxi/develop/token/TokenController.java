package com.example.ytaxi.develop.token;

import com.example.ytaxi.config.JWT.JWTUtil;
import com.example.ytaxi.develop.login.LoginServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping(value = "/token")
@Slf4j
public class TokenController {
    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * 토큰 만료 여부 return
     * @param request
     * @param token
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/isTokenExpired", method = RequestMethod.POST)
    public Boolean isTokenExpired(HttpServletRequest request, @RequestBody String token) throws Exception {
        String chkToken = token.split(" ")[1];

        boolean result;

        //토큰 소멸 시간 검증
        try{
            result = jwtUtil.isExpired(chkToken);

            return result;

        } catch (ExpiredJwtException e){
            System.out.println("isTokenExpired TRUE");

            return true;
        }
    }

    /**
     * 토큰 재발급
     * @param request
     * @param refreshToken
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/tokenRefresh", method = RequestMethod.POST)
    public String tokenRefresh(HttpServletRequest request, @RequestBody Map<String, String> refreshToken) throws Exception {
        String getToken = refreshToken.get("refreshToken").split(" ")[1];

        System.out.println(getToken);

        //토큰 소멸 시간 검증
        try{
            boolean result = jwtUtil.isExpired(getToken);

            System.out.println("result: " + result);

            if(result == true){
                return null;
            }

            //토큰에서 username과 role 획득
            String username = jwtUtil.getUsername(getToken);
            String role = jwtUtil.getRole(getToken);

            String newToken = jwtUtil.createAccessToken(username, role, 5*60000L);

            return "Bearer " +  newToken;

        } catch (ExpiredJwtException e){
            System.out.println("token expired");

            return null;
        }
    }
}
