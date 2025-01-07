package net.scit.backend.group.service;

import jakarta.servlet.http.HttpServletRequest;
import net.scit.backend.group.dto.MyGroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    Page<MyGroupDTO> getGroupList(HttpServletRequest request, Integer page);
}
