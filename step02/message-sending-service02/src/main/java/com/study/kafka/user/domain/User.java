package com.study.kafka.user.domain;

import java.time.LocalDateTime;

import com.study.kafka.user.sdo.UserCdo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User
{
    private String userId;
    private String loginFlag;
    private LocalDateTime createdDate;
    private LocalDateTime lastLoginDate;
    private LocalDateTime lastLogoutDate;

    public User(UserCdo userCdo)
    {
        this.userId = userCdo.getUserId();
        this.loginFlag = userCdo.getLoginFlag();
        this.createdDate = userCdo.getCreatedDate();
        this.lastLoginDate = getLastLogoutDate();
        this.lastLogoutDate = getLastLoginDate();
    }

}
