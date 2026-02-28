package com.back.self_jsb.post.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor      // 기본 생성자를 자동으로 만들어주는 롬복 어노테이션
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public Post(String title, String content){
        this.title = title;
        this.content = content;
        createDate = LocalDateTime.now();
        modifyDate = LocalDateTime.now();
    }

}
