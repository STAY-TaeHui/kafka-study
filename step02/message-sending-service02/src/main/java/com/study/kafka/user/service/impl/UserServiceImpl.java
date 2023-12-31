package com.study.kafka.user.service.impl;

import com.study.kafka.user.messaging.UserCommands;
import com.study.kafka.user.messaging.publisher.UserCommandPublisher;
import com.study.kafka.user.sdo.UserCdo;
import com.study.kafka.user.sdo.UserUdo;
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
        userCommands = new UserCommandPublisher();
        userCommands.send(userId);
        return userId;
    }

    @Override
    public String login(UserUdo userUdo)
    {
        userCommands.loginPublish(userUdo);
        return userUdo.getLastLoginDate().toString();
    }

    @Override
    public String logout(UserUdo userUdo)
    {
        return null;
    }
}
