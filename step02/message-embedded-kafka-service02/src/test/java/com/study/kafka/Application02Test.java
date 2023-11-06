package com.study.kafka;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.study.kafka.member.controller.MemberResource;
import com.study.kafka.user.controller.UserResource;
import com.study.kafka.user.sdo.UserCdo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@Slf4j
@SpringBootTest
//@DirtiesContext
@EmbeddedKafka(
    partitions = 1,
    topics = {
        "command.create-user",
    },
    brokerProperties = {
        "listeners=PLAINTEXT://localhost:9092",
        "port=9092"
    }
)
class Application02Test {

    @Autowired
    UserResource userResource;

    @Autowired
    MemberResource memberResource;

    @Test
    void sendTest() throws InterruptedException {
        userResource.register(new UserCdo("hong"));

        TimeUnit.SECONDS.sleep(3);

        long count = memberResource.count();
        log.debug("count: {}", count);
        assertThat(count).isEqualTo(1);

        List<String> list = memberResource.findAll();
        list.forEach(userId -> log.debug("userId: {}", userId));
    }
}
