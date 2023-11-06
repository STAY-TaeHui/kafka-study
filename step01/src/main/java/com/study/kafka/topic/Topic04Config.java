package com.study.kafka.topic;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@Configuration
public class Topic04Config {

    public static final String TOPIC_04 = "topic-04";

    @Bean
    public NewTopic topic04() {
        return TopicBuilder.name(TOPIC_04)
            .partitions(10)
            .replicas(1)
            .build();
    }

    @Bean
    public ApplicationRunner runner04(KafkaTemplate<String, String> template) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                template.send(TOPIC_04, i, Integer.toString(i), "test " + i);
            }
        };
    }

    @KafkaListener(id = "myId-04", topics = TOPIC_04)
    public void listen04(String in) {
        log.info(TOPIC_04 + ": " + in);
    }
}
