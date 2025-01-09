package net.scit.backend.group.dto;

import lombok.*;
import net.scit.backend.group.entity.GroupEntity;
import net.scit.backend.member.entity.MemberEntity;

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

    public static GroupDTO toDTO(GroupEntity groupEntity) {
        return GroupDTO.builder()
                .id(groupEntity.getId())
                .groupName(groupEntity.getGroupName())
                .createDate(groupEntity.getCreateDate())
                .build();
    }
}
