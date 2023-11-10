package com.study.kafka.user.messaging;

import com.study.kafka.user.sdo.UserUdo;

public interface UserCommands {
    void send(String userId);
    void loginPublish(UserUdo userUdo);
    void logoutPublish(UserUdo userUdo);
}
