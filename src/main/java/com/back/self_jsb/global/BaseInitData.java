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


    /*
    트랜잭션 이해하기 위한 예제
    상황: 만약 어떤 기능을 테스트 데이터가 2개라고 가정하고 개발을 진행했다면?

    첫 번째 write는 실행 -> if(true)에 의해 예외 발생 -> 두 번째 write는 실행되지 않음

    두 개의 write가 모두 실행되거나 모두 실패하도록 만들기 위해 트랜잭션을 설정하는 것
     */

    void work1(){
        try {
            if (postService.count() > 0) {
                return;
            }

            postService.write("제목1", "내용1");

            if (true) {
                throw new RuntimeException("테스트 예외");
            }

            postService.write("제목2", "내용2");
        } catch (Exception e) {
            System.out.println("예외 발생 : " +e.getMessage());
        }

    }

    void work2() {
        postService.findById(1);
    }
}
