package net.scit.backend.member.service.impl;

import lombok.RequiredArgsConstructor;
import net.scit.backend.member.dto.CustomUserDetails;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        MemberEntity userData = memberRepository.findByEmail(email);
        if (userData != null) {

            return new CustomUserDetails(userData);
        }

        return null;
    }
}