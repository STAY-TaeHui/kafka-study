package com.study.kafka.member.service;

import java.util.List;

public interface MemberService {

    List<String> findAll();

    long count();

    void register(String userId);
}
