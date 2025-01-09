package net.scit.backend.member.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.scit.backend.member.dto.CustomUserDetails;
import net.scit.backend.member.entity.MemberEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtUtil.resolveToken(request);

        // 토큰이 필요한 경로에서 토큰이 없으면 401 Unauthorized 응답
        if (token == null || token.isEmpty()) {
            if (isProtectedPath(request)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token is missing");
                return;
            }
            filterChain.doFilter(request, response); // 토큰이 필요없는 경로는 필터 진행
            return;
        }

        if (jwtUtil.isExpired(token)) {

            System.out.println("token expired");
            filterChain.doFilter(request, response);

            return;
        }

        String email = jwtUtil.getEmail(token);
        String nickname = jwtUtil.getNickname(token);

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(email);
        memberEntity.setPassword("temppassword");
        memberEntity.setNickname(nickname);

        CustomUserDetails customUserDetails = new CustomUserDetails(memberEntity);

        //스프링 시큐리티 인증 토큰 생성
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
        //세션에 사용자 등록
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }

    // 토큰이 필요한 경로인지 체크하는 메서드
    private boolean isProtectedPath(HttpServletRequest request) {
        // 예를 들어, /members/signup, /members/login 경로는 토큰이 필요 없다고 판단
        String path = request.getRequestURI();
        return !(path.startsWith("/members/signup") || path.startsWith("/login"));
    }
}
