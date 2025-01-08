package net.scit.backend.member.controller;

import lombok.RequiredArgsConstructor;
import net.scit.backend.member.dto.MemberDTO;
import net.scit.backend.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO) {
        memberService.signup(memberDTO);
        return "ok";
    }
<<<<<<< HEAD

=======
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
}
