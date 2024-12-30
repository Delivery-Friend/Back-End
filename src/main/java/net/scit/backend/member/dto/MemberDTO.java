package net.scit.backend.member.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class MemberDTO {

    private Long memberId;
    private String email;
    private String password;
    private String nickname;
//    private String profileImage;
//    private String introduction;
//    private Boolean auth;
//    private String uuid;
//    private String linkEmail;
//    private String status;
//    private LocalDate createDate;
//    private LocalDate deleteDate;

}
