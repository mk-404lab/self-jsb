package com.back.self_jsb.post.service;

import com.back.self_jsb.member.entity.Member;
import com.back.self_jsb.post.entity.Post;
import com.back.self_jsb.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/*
- PostRepository에서 이미 다양한 메서드가 존재하는데 굳이 왜 또 만들까? 라는 의문 발생
- 레이어드 아키텍처를 지키기 위해 PostService 클래스 필요
- PostRepository는 온전히 DB 작업을 위해 존재
- PostService는 로직 처리 담당
*/

@Service    // @Component와 같은 기능, 가독성을 위해 Service 클래스임을 명시하고자 사용
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post write(Member author, String title, String content){
        Post post = new Post(author, title, content);
        return postRepository.save(post);
    }

    @Transactional
    public Post modify(Post post, String newTitle, String newContent){
        post.setTitle(newTitle);
        post.setContent(newContent);
        //return postRepository.save(post);
        return post;
    }

    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public long count(){
        return postRepository.count();
    }

}
