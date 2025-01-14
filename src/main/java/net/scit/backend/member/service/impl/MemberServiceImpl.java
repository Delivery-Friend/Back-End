package net.scit.backend.member.service.impl;

import lombok.RequiredArgsConstructor;
import net.scit.backend.member.dto.MemberDTO;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.member.repository.MemberRepository;
import net.scit.backend.member.service.MemberService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void signup(MemberDTO memberDTO) {

        String email = memberDTO.getEmail();
        String password = memberDTO.getPassword();
        String nickname = memberDTO.getNickname();

        Boolean isExist = memberRepository.existsByEmail(email);
        if(isExist) {
            return;
        }

        MemberEntity data = new MemberEntity();
        data.setEmail(email);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setNickname(nickname);
        data.setRole("ROLE_USER");

        memberRepository.save(data);
    }
}
