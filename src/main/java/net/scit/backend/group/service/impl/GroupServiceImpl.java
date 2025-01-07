package net.scit.backend.group.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.scit.backend.group.dto.GroupDTO;
import net.scit.backend.group.entity.GroupEntity;
import net.scit.backend.group.repository.GroupRepository;
import net.scit.backend.group.service.GroupService;
import net.scit.backend.member.entity.MemberEntity;
import net.scit.backend.member.jwt.JWTUtil;
import net.scit.backend.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final JWTUtil jwtUtil;

    @Override
    public Map<String, Object> createGroup(HttpServletRequest request, String groupName) {
        // 1. 토큰 처리
        String token = jwtUtil.resolveToken(request);
        String email = jwtUtil.getEmail(token);

        Optional<MemberEntity> byEmail = memberRepository.findByEmail(email);
        if (byEmail.isEmpty()) {
            // CustomException 으로 교체 예정
            throw new RuntimeException("not found member");
        }

        MemberEntity member = byEmail.get();

        // 2. GroupDTO -> GroupEntity로 변환
        GroupDTO groupDTO = GroupDTO.builder()
                .member(member)
                .groupName(groupName)
                .createDate(LocalDate.now())
                .build();
        GroupEntity groupEntity = GroupEntity.toEntity(groupDTO);

        // 3. 데이터베이스에 저장
        groupRepository.save(groupEntity);

        Map<String, Object> result = new HashMap<>();
        result.put("success", true);

        return result;
    }
}
