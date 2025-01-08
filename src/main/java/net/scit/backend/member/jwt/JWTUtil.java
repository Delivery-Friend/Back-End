package net.scit.backend.member.jwt;

import io.jsonwebtoken.Jwts;
<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;
=======
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    private SecretKey secretKey;

<<<<<<< HEAD
    public JWTUtil(@Value("${spring.jwt.secret}") String secret) {
=======
    public JWTUtil(@Value("${spring.jwt.secret}")String secret) {
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0

        secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public String getEmail(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("email", String.class);
    }

    public String getNickname(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().get("nickname", String.class);
    }

    public Boolean isExpired(String token) {

        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }

    public String createJwt(String email, String nickname, Long expiredMs) {

        return Jwts.builder()
                .claim("email", email)
                .claim("nickname", nickname)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(secretKey)
                .compact();
    }

<<<<<<< HEAD
    // 토큰 파싱 메서드
    public String resolveToken(HttpServletRequest request) {
        final String BEARER = "Bearer ";

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith(BEARER)) {
            token = token.substring(BEARER.length()); // "Bearer " 이후의 토큰 값만 추출
        }
        return token;
    }

=======
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
}
