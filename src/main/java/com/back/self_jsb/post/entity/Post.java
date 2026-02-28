package com.back.self_jsb.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor      // 기본 생성자를 자동으로 만들어주는 롬복 어노테이션
@Setter                 // 롬복의 Setter, Getter 어노테이션을 추가하면 setTitle, getTitle과 같은 메서드를
@Getter                 // 직접 구현할 필요가 없다.
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
