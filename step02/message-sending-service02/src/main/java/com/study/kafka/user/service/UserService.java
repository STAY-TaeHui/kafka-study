package com.study.kafka.user.service;

import com.study.kafka.user.sdo.UserCdo;

public interface UserService {
    String register(UserCdo userCdo);
}
