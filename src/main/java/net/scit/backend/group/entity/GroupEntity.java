package net.scit.backend.group.entity;

import jakarta.persistence.*;
import lombok.*;
import net.scit.backend.member.entity.MemberEntity;

import java.time.LocalDate;

@Entity
@Table(name = "group")
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
    @Column(name = "member_id")
    private MemberEntity member;

    private String groupName;
    private LocalDate createDate;
}
