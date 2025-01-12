package net.scit.backend.group.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.group.dto.GroupDTO;
import net.scit.backend.member.entity.MemberEntity;

import java.time.LocalDate;

@Entity
@Table(name = "`group`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Column(name = "group_name")
    private String groupName;

    private LocalDate createDate;

    // dto -> entity
    public static GroupEntity toEntity(GroupDTO dto) {
        return GroupEntity.builder()
                .id(dto.getId())
                .member(dto.getMember())
                .groupName(dto.getGroupName())
                .createDate(dto.getCreateDate())
                .build();
    }
}
