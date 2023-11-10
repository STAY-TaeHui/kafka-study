package com.study.kafka.user.service;

import static org.junit.jupiter.api.Assertions.*;

import com.study.kafka.user.domain.User;
import com.study.kafka.user.sdo.UserCdo;
import com.study.kafka.user.sdo.UserUdo;
import com.study.kafka.user.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class UserServiceTest
{
    static User user;

    @Autowired
    UserServiceImpl userService;

    @BeforeEach
    void newUser(){
        user = new User(UserCdo.sample());
    }

    @Test
    void login()
    {
        UserUdo userUdo = new UserUdo(user);
        userUdo.login();

        log.debug("LOGIN : "+ userService.login(userUdo));

    }

    @Test
    void logout()
    {
        UserUdo userUdo = new UserUdo(user);
        userUdo.logout();

        log.debug("LOGOUT : "+ userService.logout(userUdo));

    }
}