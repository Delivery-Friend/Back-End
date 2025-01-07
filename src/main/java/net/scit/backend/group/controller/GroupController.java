package net.scit.backend.group.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import net.scit.backend.group.dto.MyGroupDTO;
import net.scit.backend.group.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping("/list")
    public ResponseEntity<Page<MyGroupDTO>> getGroupList(HttpServletRequest request, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Page<MyGroupDTO> groupList = groupService.getGroupList(request, page);
        return ResponseEntity.ok(groupList);
    }
}
