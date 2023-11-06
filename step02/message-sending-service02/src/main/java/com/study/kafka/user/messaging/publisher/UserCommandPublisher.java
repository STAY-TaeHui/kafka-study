package com.study.kafka.user.messaging.publisher;

import com.study.kafka.user.messaging.UserCommands;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCommandPublisher implements UserCommands {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String userId) {
        kafkaTemplate.send("command.create-user", userId);
    }
}
