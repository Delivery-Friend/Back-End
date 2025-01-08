package net.scit.backend.group.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.scit.backend.group.dto.MyGroupDTO;
import net.scit.backend.group.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createGroup(HttpServletRequest request,
                                                           @RequestParam String groupName) {
        // 그룹 생성
        Map<String, Object> result = groupService.createGroup(request, groupName);
        return ResponseEntity.ok(result);//생성된 결과를 클라이언트에게 반환
    }

    @GetMapping("/list")
    public ResponseEntity<Page<MyGroupDTO>> getGroupList(HttpServletRequest request, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Page<MyGroupDTO> groupList = groupService.getGroupList(request, page);
        return ResponseEntity.ok(groupList);
    }
}
