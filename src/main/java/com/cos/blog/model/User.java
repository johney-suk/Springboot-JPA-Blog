package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

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
public class User {

	@Id // PK key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝에서 연결된 DB 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment

	@Column(nullable = false, length = 30)
	private String username;
  
	@Column(nullable = false, length = 100)
	private String password;

	@Column(nullable = false, length = 50)
	private String email;

	@ColumnDefault("'user'")
	private String role; // Enum을 쓰는 좋다.
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;
}
