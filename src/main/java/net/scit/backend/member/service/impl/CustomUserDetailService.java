package net.scit.backend.member.service.impl;

import lombok.RequiredArgsConstructor;
import net.scit.backend.member.dto.CustomUserDetails;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

<<<<<<< HEAD
        Optional<MemberEntity> userData = memberRepository.findByEmail(email);
        if (userData.isPresent()) {
            MemberEntity member = userData.get();
            return new CustomUserDetails(member);
=======
        MemberEntity userData = memberRepository.findByEmail(email);
        if (userData != null) {

            return new CustomUserDetails(userData);
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
        }

        return null;
    }
}
