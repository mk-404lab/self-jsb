package com.back.self_jsb.post.entity;

import com.back.global.entity.BaseEntity;
import com.back.self_jsb.member.entity.Member;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    private Member author;


    /*
    private int authorId;
    이와 같이 변수를 선언하고 Member 클래스에서 id 값을 int로 받아오는 것은 DB적 사고! => JPA를 사용하는 것이 아님
    JAVA적 사고는 Member 클래스의 객체를 통을 떼와서 저장하는 것 (객체 지향)
    Member 타입의 author를 Post 클래스에 포함하고 MemberService에 접근하여 findById(3).get()과 같이 객체를 떼오고 저장하여 PostService에 전달하는 방식으로 활용
     */


    public Post(Member author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }

}
