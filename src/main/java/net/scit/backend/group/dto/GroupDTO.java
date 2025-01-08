package net.scit.backend.group.dto;

import lombok.*;
<<<<<<< HEAD
import net.scit.backend.group.entity.GroupEntity;
=======
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
import net.scit.backend.member.entity.MemberEntity;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupDTO {

    private Long id;
<<<<<<< HEAD
    private MemberEntity member;
    private String groupName;
    private LocalDate createDate;

    public static GroupDTO toDTO(GroupEntity groupEntity) {
        return GroupDTO.builder()
                .id(groupEntity.getId())
                .groupName(groupEntity.getGroupName())
                .createDate(groupEntity.getCreateDate())
                .build();
    }
=======
    //private MemberEntity member;
    private String groupName;
    private LocalDate createDate;
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
}
