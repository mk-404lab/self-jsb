package com.back.self_jsb.global;

import com.back.self_jsb.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Bean
    ApplicationRunner initDataRunner() {
        return args -> {

            work1();
            work2();
        };
    }

    void work1(){
        if(postService.count() > 0){
            return;
        }

        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");
    }

    void work2() {
        postService.findById(1);
    }
}
