package net.scit.backend.member.service;

import net.scit.backend.member.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    public void signup(MemberDTO memberDTO);
}
