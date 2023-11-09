package com.study.kafka.user.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User
{
    private String userId;
    private String loginFlag;
    private LocalDateTime createdDate;
    private LocalDateTime lastLoginDate;
    private LocalDateTime lastLogoutDate;
}
