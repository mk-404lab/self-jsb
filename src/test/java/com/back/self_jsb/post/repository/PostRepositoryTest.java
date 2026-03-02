package com.back.self_jsb.post.repository;

import com.back.self_jsb.post.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    @Rollback
    void t1(){
        Post post = postRepository.findById(2).get();

        assertThat(post.getId()).isEqualTo(2);
        assertThat(post.getTitle()).isEqualTo("제목2");
        assertThat(post.getContent()).isEqualTo("내용2");
    }

    /*
    @Transactional로 테스트를 하나의 업무 단위로 지정
    @Rollback을 통해 하나의 트랜잭션이 종료되면 DB에 반영된 변경을 전부 없었던 일로 원복함
    => 테스트는 rollback=true가 기본값이다.
    => 만약 t2에서 rollbac=false로 설정할 경우 원복되지 않기 때문에 BaseInitData에서 저장하는 데이터 2개 + t2에서 저장하는 데이터 1개로 인해 총 3개의 데이터가 저장되므로 t3가 실패하게 됨
     */

    @Test
    @Transactional
    @Rollback
    void t2(){
        Post post = new Post("제목3", "내용3");
        Post savedPost = postRepository.save(post);

        assertThat(savedPost.getId()).isNotNull();
        assertThat(savedPost.getTitle()).isEqualTo("제목3");
        assertThat(savedPost.getContent()).isEqualTo("내용3");
    }

    @Test
    @Transactional
    @Rollback
    void t3() {
        long cnt = postRepository.count();
        assertThat(cnt).isEqualTo(2);
    }
}
