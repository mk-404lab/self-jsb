package com.back.global;

import com.back.self_jsb.entity.Post;
import com.back.self_jsb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseInitData {

    @Autowired
    private PostRepository postRepository;

    @Bean
    ApplicationRunner initDataRunner() {
        return args -> {
            System.out.println("초기 데이터를 로딩합니다.");

            Post post1 = new Post("제목1", "내용1");
            postRepository.save(post1);
        };
    }
}
