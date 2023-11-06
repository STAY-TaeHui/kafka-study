package com.study.kafka.user.controller;

import static java.util.stream.IntStream.rangeClosed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.study.kafka.user.sdo.UserCdo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserResourceTest {

    @Autowired
    UserResource userResource;

    @Test
    void register() {
        UserCdo userCdo = UserCdo.sample();
        userResource.register(userCdo);
    }

    @Test
    void registerAll() throws InterruptedException {
        int requestCount = 10000;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(requestCount);

        rangeClosed(1, requestCount).forEach(value -> executorService.submit(() -> {
            try {
                String userId = "user-" + value;
                userResource.register(new UserCdo(userId));
            } finally {
                countDownLatch.countDown();
            }
        }));

        countDownLatch.await();
    }
}
