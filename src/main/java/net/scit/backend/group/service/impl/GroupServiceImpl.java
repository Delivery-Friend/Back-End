package net.scit.backend.group.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.scit.backend.exception.impl.GroupNotFoundException;
import net.scit.backend.exception.impl.MemberNotFoundException;
import net.scit.backend.group.dto.MyGroupDTO;
import net.scit.backend.group.entity.GroupMemberEntity;
import net.scit.backend.group.repository.GroupMemberRepository;
import net.scit.backend.group.service.GroupService;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.member.jwt.JWTUtil;
import net.scit.backend.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final MemberRepository memberRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final JWTUtil jwtUtil;

    @Override
    public Page<MyGroupDTO> getGroupList(HttpServletRequest request, Integer page) {
        String token = jwtUtil.resolveToken(request);
        String email = jwtUtil.getEmail(token);

        Optional<MemberEntity> byEmail = memberRepository.findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new MemberNotFoundException();
        }

        MemberEntity member = byEmail.get();
        List<GroupMemberEntity> groupMemberEntities = groupMemberRepository.findAllByMemberId(member.getId());

        if (groupMemberEntities.isEmpty()) {
            throw new GroupNotFoundException();
        }

        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "lastAccessDate"));

        Page<MyGroupDTO> groupDTOPage = groupMemberRepository
                .findAllByMemberId(member.getId(), pageable)
                .map(groupMember -> {
                    // 그룹 정보를 MyGroupDTO로 변환
                    return new MyGroupDTO().builder()
                            .id(groupMember.getGroup().getId())
                            .groupName(groupMember.getGroup().getGroupName())
                            .build();
                });

        return groupDTOPage;
    }
}
