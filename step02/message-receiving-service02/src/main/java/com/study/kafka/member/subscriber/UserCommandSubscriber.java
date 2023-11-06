package com.study.kafka.member.subscriber;

import com.study.kafka.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(
    topics = "command.create-user",
    groupId = "member-subscriber"
)
@RequiredArgsConstructor
public class UserCommandSubscriber {

    private final MemberService memberService;

    @KafkaHandler
    public void handle(String userId) {
        log.debug("userId: {}", userId);
        memberService.register(userId);
    }

    @KafkaHandler(isDefault = true)
    public void ignore(Object object) {
        log.debug(object.toString());
    }
}
