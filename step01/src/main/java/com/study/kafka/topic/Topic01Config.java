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
public class Topic01Config {

    public static final String TOPIC_01 = "topic-01";

    @Bean
    public NewTopic topic01() {
        return TopicBuilder.name(TOPIC_01)
            .partitions(10)
            .replicas(1)
            .build();
    }

    @Bean
    public ApplicationRunner runner01(KafkaTemplate<String, String> template) {
        return args -> template.send(TOPIC_01, "test");
    }

    @KafkaListener(id = "myId-01", topics = TOPIC_01)
    public void listen01(String in) {
        log.info(TOPIC_01 + ": " + in);
    }
}
