package net.scit.backend.member.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.scit.backend.member.dto.CustomUserDetails;
import net.scit.backend.member.dto.TokenDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    @PostConstruct
    public void init() {
        setFilterProcessesUrl("/members/login");  // 로그인 URL 설정
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter("email");  // "email"을 로그인 ID로 사용
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String email = obtainUsername(request);
        String password = obtainPassword(request);

        if (email == null || password == null) {
            throw new AuthenticationException("Email or password is missing") {};  // 오류 처리
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);

        // 인증 요청
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) {
        // 인증 성공 후 JWT 토큰 생성 및 응답 처리
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String email = customUserDetails.getUsername();
        String nickname = customUserDetails.getNickname();
        String role = customUserDetails.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("ROLE_USER");  // 기본 역할 설정

        String accessToken = jwtUtil.createJwt(email, nickname, role, 2 * 60 * 60 * 1000L);  // 2시간 유효
        String refreshToken = jwtUtil.createJwt(email, nickname, role, 7 * 24 * 60 * 60 * 1000L);  // 7일 유효

        // TokenDTO에 토큰 저장
        TokenDTO jwtResponse = TokenDTO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        // 응답 Content-Type 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // JSON으로 응답 Body에 쓰기
        try {
            response.getWriter().write(new ObjectMapper().writeValueAsString(jwtResponse));
        } catch (Exception e) {
            e.printStackTrace();  // 예외 처리 추가
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        // 로그인 실패 시 401 상태 코드와 오류 메시지 응답
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        try {
            response.getWriter().write("{\"error\": \"Invalid email or password\"}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


