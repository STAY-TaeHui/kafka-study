package com.study.kafka.user.sdo;

import java.time.LocalDateTime;

import com.study.kafka.user.domain.User;
import com.study.share.util.JsonSerializable;
import com.study.share.util.SamplePrinter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUdo implements JsonSerializable {

    private String userId;
    private String loginFlag;
    private LocalDateTime lastLoginDate;
    private LocalDateTime lastLogoutDate;

    public UserUdo(User user)
    {
        this.userId = user.getUserId();
        this.loginFlag = user.getLoginFlag();
        this.lastLoginDate = user.getLastLoginDate();
        this.lastLogoutDate = user.getLastLogoutDate();
    }

    @Override
    public String toString() {
        return toJson();
    }

    public void login()
    {
        this.loginFlag = "Y";
        this.lastLoginDate = LocalDateTime.now();
    }

    public void logout()
    {
        this.loginFlag = "N";
        this.lastLogoutDate = LocalDateTime.now();
    }
}
