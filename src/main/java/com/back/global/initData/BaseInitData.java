package com.back.global.initData;

import com.back.self_jsb.member.service.MemberService;
import com.back.self_jsb.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseInitData {

    @Autowired
    @Lazy
    private BaseInitData self;

    private final PostService postService;
    private final MemberService memberService;

    @Bean
    ApplicationRunner devInitdata() {
        return args -> {

            self.work2();
            self.work1();

        };
    }

    @Transactional
    void work1(){

        if (postService.count() > 0) {
            return;
        }

        postService.write(3, "제목1", "내용1");
        postService.write(4, "제목2", "내용2");

    }

    @Transactional
    void work2() {
        memberService.join("systemUser", "1234", "시스템");
        memberService.join("adminUser", "1234", "관리자");
        memberService.join("user1", "1234", "유저1");
        memberService.join("user2", "1234", "유저2");
        memberService.join("user3", "1234", "유저3");
    }
}
