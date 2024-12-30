package net.scit.backend.group.service.impl;

import lombok.RequiredArgsConstructor;
import net.scit.backend.group.dto.GroupDTO;
import net.scit.backend.group.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    @Override
    public List<GroupDTO> getGroupList(String authorizationHeader) {
        return List.of();
    }
}
