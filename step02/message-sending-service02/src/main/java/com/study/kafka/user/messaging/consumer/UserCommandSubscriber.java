package com.study.kafka.user.messaging.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCommandSubscriber
{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void loginSubscribe(){

    }
}
