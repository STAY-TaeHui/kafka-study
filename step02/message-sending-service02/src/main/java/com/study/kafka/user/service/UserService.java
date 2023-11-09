package com.study.kafka.user.service;

import com.study.kafka.user.sdo.UserCdo;
import com.study.kafka.user.sdo.UserUdo;

public interface UserService {
    String register(UserCdo userCdo);
    //TODO login/logout 로그를 만들어보자.
    String login(UserUdo userUdo);
    String logout(UserUdo userUdo);
}
