package com.study.kafka.user.sdo;

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

    public static UserCdo sample() {
        return new UserCdo("hong");
    }

    public static void main(String[] args) {
        SamplePrinter.println(sample());
    }

    @Override
    public String toString() {
        return toJson();
    }
}
