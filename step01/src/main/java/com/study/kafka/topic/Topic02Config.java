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
public class Topic02Config {

    public static final String TOPIC_02 = "topic-02";

    @Bean
    public NewTopic topic02() {
        return TopicBuilder.name(TOPIC_02)
            .partitions(10)
            .replicas(1)
            .build();
    }

    @Bean
    public ApplicationRunner runner02(KafkaTemplate<String, String> template) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                template.send(TOPIC_02, "test " + i);
            }
        };
    }

    @KafkaListener(id = "myId-02", topics = TOPIC_02)
    public void listen02(String in) {
        log.info(TOPIC_02 + ": " + in);
    }
}
