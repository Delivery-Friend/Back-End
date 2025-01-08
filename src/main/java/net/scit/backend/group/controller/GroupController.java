<<<<<<< HEAD
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
=======
package net.scit.backend.group.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

}
>>>>>>> c24b24be0d2d41e04033990e8fa3742db0bd74c0
