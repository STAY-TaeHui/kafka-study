package com.study.kafka.member.controller;

import java.util.List;

import com.study.kafka.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberResource {

    private final MemberService memberService;

    @GetMapping
    public List<String> findAll() {
        return memberService.findAll();
    }

    @GetMapping("count")
    public long count() {
        return memberService.count();
    }
}
