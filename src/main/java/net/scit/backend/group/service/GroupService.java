package net.scit.backend.group.service;

import jakarta.servlet.http.HttpServletRequest;
import net.scit.backend.group.dto.GroupDTO;
import net.scit.backend.group.entity.GroupEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface GroupService {

    Map<String, Object> createGroup(HttpServletRequest request, String groupName);
}
