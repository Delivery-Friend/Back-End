package net.scit.backend.group.service;

import net.scit.backend.group.dto.GroupDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    List<GroupDTO> getGroupList(String authorizationHeader);
}
