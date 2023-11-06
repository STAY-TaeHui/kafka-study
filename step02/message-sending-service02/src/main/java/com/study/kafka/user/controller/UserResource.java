package com.study.kafka.user.controller;

import com.study.kafka.user.sdo.UserCdo;
import com.study.kafka.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserResource {

    private final UserService userService;

    @PostMapping
    public String register(
        @RequestBody UserCdo userCdo
    ) {
        return userService.register(userCdo);
    }
}
