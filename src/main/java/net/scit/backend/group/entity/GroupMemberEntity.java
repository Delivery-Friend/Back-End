package net.scit.backend.group.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.member.entity.MemberEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "group_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupmember_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    private LocalDateTime lastAccessDate;
}
