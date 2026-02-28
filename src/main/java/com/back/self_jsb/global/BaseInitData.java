package com.back.self_jsb.global;

import com.back.self_jsb.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostService postService;

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
