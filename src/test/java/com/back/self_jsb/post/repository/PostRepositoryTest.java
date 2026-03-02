package com.back.self_jsb.post.repository;

import com.back.self_jsb.post.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional      // @RollBack는 테스트에서 기본값이므로 생략 가능, 클래스 단위에 트랜잭션을 붙일 경우 그 단위는 메서드에 개별적으로 적용됨(클래스 전체가 트랜잭션 단위가 되는 게 아님, 단순히 중복되는 어노테이션을 한 번에 정의한 것)
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void t1(){
        Post post = postRepository.findById(2).get();

        assertThat(post.getId()).isEqualTo(2);
        assertThat(post.getTitle()).isEqualTo("제목2");
        assertThat(post.getContent()).isEqualTo("내용2");
    }

    @Test
    void t2(){
        Post post = new Post("제목3", "내용3");
        Post savedPost = postRepository.save(post);

        assertThat(savedPost.getId()).isNotNull();
        assertThat(savedPost.getTitle()).isEqualTo("제목3");
        assertThat(savedPost.getContent()).isEqualTo("내용3");
    }

    @Test
    void t3() {
        long cnt = postRepository.count();
        assertThat(cnt).isEqualTo(2);
    }
}
