package com.back.self_jsb.post.entity;

import com.back.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor      // 기본 생성자를 자동으로 만들어주는 롬복 어노테이션
@Setter                 // 롬복의 Setter, Getter 어노테이션을 추가하면 setTitle, getTitle과 같은 메서드를
@Getter                 // 직접 구현할 필요가 없다.
public class Post extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private int authorId;

    public Post(int authorId, String title, String content){
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }

}
