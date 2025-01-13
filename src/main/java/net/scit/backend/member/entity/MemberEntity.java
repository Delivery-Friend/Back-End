package net.scit.backend.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="`member`")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="nickname", nullable = false)
    private String nickname;

    @Column(name="role")
    @Builder.Default
    private String role = "ROLE_USER";

    @Column(name="profile_image")
    private String profileImage;

    @Column(name="introduction")
    private String introduction;

    @Column(name="auth")
    private Boolean auth;

    @Column(name="uuid")
    private String uuid;

    @Column(name="link_email")
    private String linkEmail;

    @Column(name="status")
    private String status;

    @Column(name="create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name="delete_date")
    private LocalDateTime deleteDate;

}
