package net.scit.backend.group.service;

<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;
import net.scit.backend.group.dto.MyGroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    Page<MyGroupDTO> getGroupList(HttpServletRequest request, Integer page);
=======
import org.springframework.stereotype.Service;

@Service
public interface GroupService {
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
}
