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


    public GroupDTO toDTO(GroupEntity entity){
        return GroupDTO.builder()
                .id(entity.getId())
                .member(entity.getMember())
                .groupName(entity.getGroupName())
                .createDate(entity.getCreateDate())
                .build();
    }
}
