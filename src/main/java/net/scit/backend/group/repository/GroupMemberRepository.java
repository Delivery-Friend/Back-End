package net.scit.backend.group.repository;

import net.scit.backend.group.entity.GroupMemberEntity;
import net.scit.backend.member.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMemberEntity, Long> {
    List<GroupMemberEntity> findAllByMemberId(Long memberId);
    Page<GroupMemberEntity> findAllByMemberId(Long memberId, Pageable pageable);
}
