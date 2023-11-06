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
public class Topic03Config {

    public static final String TOPIC_03 = "topic-03";

    @Bean
    public NewTopic topic03() {
        return TopicBuilder.name(TOPIC_03)
            .partitions(10)
            .replicas(1)
            .build();
    }

    @Bean
    public ApplicationRunner runner03(KafkaTemplate<String, String> template) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                template.send(TOPIC_03, Integer.toString(i), "test " + i);
            }
        };
    }

    @KafkaListener(id = "myId-03", topics = TOPIC_03)
    public void listen03(String in) {
        log.info(TOPIC_03 + ": " + in);
    }
}
