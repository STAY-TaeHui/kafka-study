package com.study.kafka.user.service.impl;

import com.study.kafka.user.messaging.UserCommands;
import com.study.kafka.user.sdo.UserCdo;
import com.study.kafka.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserCommands userCommands;

    @Override
    public String register(UserCdo userCdo) {
        String userId = userCdo.getUserId();
        userCommands.send(userId);
        return userId;
    }
}
