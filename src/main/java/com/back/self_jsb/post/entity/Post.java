package com.back.self_jsb.post.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor      // 기본 생성자를 자동으로 만들어주는 롬복 어노테이션
@RequiredArgsConstructor    // 필수적인 필드만 포함하여 자동으로 생성자를 만들어줌
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private final String title = "";

    @Column(columnDefinition = "TEXT", nullable = false)
    private final String content = "";

}
