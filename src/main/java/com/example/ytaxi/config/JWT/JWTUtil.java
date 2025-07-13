package com.example.ytaxi.config.JWT;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {
    private SecretKey secretKey;

    public JWTUtil(@Value("${spring.jwt.secret}")String secret) {

        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public String getUsername(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("username", String.class);
    }

    public String getRole(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("role", String.class);
    }

    public Boolean isExpired(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }

    public String createAccessToken(String username, String role, Long expiredMs) {

        return Jwts.builder()
                .claim("userId", username)
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(secretKey)
                .compact();
    }

    public String createRefreshToken(String username, String role, Long expiredMs) {

        String token = Jwts.builder()
                .claim("userId", username)
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(secretKey)
                .compact();

        // redisTemplate.opsForValue().set(REFRESH_TOKEN_KEY_PREFIX + userId, token, Duration.ofMillis(refreshTokenValidMillisecond));
        // 추후 redis에 refresh토큰 저장해서 사용 -> 기간을 정해서 db에서 자동 삭제되도록 할 수 있다고 함!
        // 참고: https://velog.io/@joona95/%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%8B%9C-JWT-refresh-token-%EC%B6%94%EA%B0%80

        return token;
    }
}
