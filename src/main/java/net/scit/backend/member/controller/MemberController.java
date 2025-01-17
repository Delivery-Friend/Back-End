package net.scit.backend.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.scit.backend.common.ResponseDTO;
import net.scit.backend.member.dto.MemberDTO;
import net.scit.backend.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO) {
        memberService.signup(memberDTO);
        return "ok";
    }

    @GetMapping("/email-check")
    public ResponseDTO<Map<String, Object>> emailCheck(@RequestParam String email) {
        log.info("emailCheck email: {}", email);
        boolean result = memberService.emailCheck(email);
        log.info("emailCheck emailllllllllll: {}", result);

        Map<String, Object> data = new HashMap<>();
        data.put("success", result);

        // ResponseDTO 객체 생성 후 setter로 값 설정
        ResponseDTO<Map<String, Object>> responseDTO = new ResponseDTO<>();
        responseDTO.setMessage(result ? "사용 가능한 이메일입니다." : "사용 불가능한 이메일입니다.");
        responseDTO.setData(data);

        return responseDTO;
    }
}
