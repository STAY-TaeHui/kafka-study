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
public class UserCdo implements JsonSerializable {

    private String userId;
    private LocalDateTime createdDate;
    public static UserCdo sample() {
        return new UserCdo("hong", LocalDateTime.now());
    }

    public static void main(String[] args) {
        SamplePrinter.println(sample());
    }

    @Override
    public String toString() {
        return toJson();
    }
}
