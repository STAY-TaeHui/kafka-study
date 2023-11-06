package com.study.kafka.member.store;

import java.util.List;

public interface MemberStore {

    List<String> findAll();

    long count();

    void saveAll(List<String> userIds);
}
