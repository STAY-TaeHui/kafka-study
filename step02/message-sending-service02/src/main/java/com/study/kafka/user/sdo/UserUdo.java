package com.study.kafka.user.sdo;

import java.time.LocalDateTime;

import com.study.share.util.JsonSerializable;
import com.study.share.util.SamplePrinter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUdo implements JsonSerializable {

    private String userId;
    private LocalDateTime lastLoginDate;
    private LocalDateTime lastLogoutDate;


    @Override
    public String toString() {
        return toJson();
    }
}
