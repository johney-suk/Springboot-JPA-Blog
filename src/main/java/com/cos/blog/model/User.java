package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴 
// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술 
@Entity // User 클래스가 DB에 테이블로 생성된다.
//@DynamicInsert // insert시에 null인 필드를 제외시켜준다.
public class User {

	@Id // PK key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝에서 연결된 DB 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment

	@Column(nullable = false, length = 100, unique = true)
	private String username;
  
	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 50)
	private String email;

	// @ColumnDefault("user")
	// DB에는 RoleType이라는 게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는 좋다. // ADMIN, USER
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;
}

