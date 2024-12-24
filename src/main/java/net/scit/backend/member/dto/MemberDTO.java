package net.scit.backend.member.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
	private Long memberId;
	private String email;
	private String password;
	private String nickname;
	private String profileImage;
	private String introduction;
	private Boolean auth;
	private String uuid;
	private String linkEmail;
	private LocalDate createDate;
	private LocalDate deleteDate;
}
