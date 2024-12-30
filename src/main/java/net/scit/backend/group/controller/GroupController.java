package net.scit.backend.group.controller;

import lombok.RequiredArgsConstructor;
import net.scit.backend.group.dto.GroupDTO;
import net.scit.backend.group.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping("/list")
    public List<GroupDTO> getGroupList(@RequestHeader("Authorization") String authorizationHeader) {
        groupService.getGroupList(authorizationHeader);
    }
}
