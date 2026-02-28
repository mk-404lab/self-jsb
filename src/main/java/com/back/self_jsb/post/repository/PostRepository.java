package com.back.self_jsb.post.repository;

import com.back.self_jsb.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//인터페이스는 인터페이스를 상속받을 수 있음
public interface PostRepository extends JpaRepository<Post, Integer> {
}
