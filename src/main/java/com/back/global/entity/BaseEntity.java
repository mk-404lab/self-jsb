package com.back.global.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
id, createDate, modifyDate는 모든 엔티티의 기본 속성으로 사용됨에 따라 BaseEntity 클래스에 모아두고 Post와 같은 각 클래스에서 상속 받아 사용한다.
@MappedSuperclass는 온전히 필드를 상속하기 위해 사용하는 것으로, 테이블 생성되지 않음
 */

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
abstract public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;
}
