package com.study.kafka.member.store.mem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.study.kafka.member.store.MemberStore;
import org.springframework.stereotype.Repository;

@Repository
public class MemberMemoryStore implements MemberStore {

    private final Set<String> userIdSet = new HashSet<>();

    @Override
    public List<String> findAll() {
        return new ArrayList<>(userIdSet);
    }

    @Override
    public long count() {
        return userIdSet.size();
    }

    @Override
    public void saveAll(List<String> userIds) {
        userIdSet.addAll(userIds);
    }
}
