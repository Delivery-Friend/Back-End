package net.scit.backend.group.entity;

import jakarta.persistence.*;
import lombok.*;
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

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Column(name = "group_name")
    private String groupName;

=======
    //@Column(name = "member_id")
    //private MemberEntity member;

    private String groupName;
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
    private LocalDate createDate;
}
