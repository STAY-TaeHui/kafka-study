package com.study.kafka.member.subscriber;

import java.util.List;

import com.study.kafka.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(
    topics = "command.create-user",
    groupId = "member-batch-subscriber",
    containerFactory = "batchFactory",
    properties = {
        ConsumerConfig.MAX_POLL_RECORDS_CONFIG + "=1000",
        ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG + "=2000",
        ConsumerConfig.FETCH_MIN_BYTES_CONFIG + "=" + (2 * 1024 * 1024)
    }
)
@RequiredArgsConstructor
public class UserCommandSubscriber {

    private final MemberService memberService;

    @KafkaHandler
    public void handle(List<String> userIds) {
        log.debug("userIds count: {}", userIds.size());

        memberService.registerAll(userIds);
    }

    @KafkaHandler(isDefault = true)
    public void ignore(Object object) {
        log.debug(object.toString());
    }
}
