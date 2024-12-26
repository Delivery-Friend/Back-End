package net.scit.backend.group.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDTO {

    private Long id;
    private MemberEntity member;
    private String groupName;
    private LocalDate createDate;
}
