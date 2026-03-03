package com.back.global;

import com.back.self_jsb.post.entity.Post;
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

    @Bean
    ApplicationRunner devInitdata() {
        return args -> {

            self.work1();
            self.work2();
            self.work3();
        };
    }

    @Transactional
    void work1(){

        if (postService.count() > 0) {
            return;
        }

        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");

    }

    void work2() {
        postService.findById(1);
    }

    @Transactional
    void work3() {
        Post post = postService.findById(1).get();
        postService.modify(post, "제목1-1", "내용1-1");
    }
}
