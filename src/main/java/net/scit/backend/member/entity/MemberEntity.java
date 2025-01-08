package net.scit.backend.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="`member`")
@Getter
@Setter
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
<<<<<<< HEAD
    private Long id;
=======
    private Long memberId;
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="nickname", nullable = false)
    private String nickname;

//    @Column(name="profile_image")
//    private String profileImage;
//    @Column(name="introduction")
//    private String introduction;
//    @Column(name="auth")
//    private Boolean auth;
//    @Column(name="uuid")
//    private String uuid;
//    @Column(name="linkEmail")
//    private String linkEmail;
//    @Column(name="status")
//    private String status;
//    @Column(name="create_date")
//    private LocalDate createDate;
//    @Column(name="delete_date")
//    private LocalDate deleteDate;

}
