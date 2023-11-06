package com.study.kafka.member.service.impl;

import java.util.List;

import com.study.kafka.member.service.MemberService;
import com.study.kafka.member.store.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberStore memberStore;

    @Override
    public List<String> findAll() {
        return memberStore.findAll();
    }

    @Override
    public long count() {
        return memberStore.count();
    }

    @Override
    public void registerAll(List<String> userIds) {
        memberStore.saveAll(userIds);
    }
}
