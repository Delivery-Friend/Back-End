package net.scit.backend.member.repository;

import net.scit.backend.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Boolean existsByEmail(String email);

<<<<<<< HEAD
    Optional<MemberEntity> findByEmail(String email);
=======
    MemberEntity findByEmail(String email);
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
}
