package com.example.Lee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//jakarta.persistence 패키지의 Entity 어노테이션을 사용하여 이 클래스가 JPA 엔티티임을 표시합니다.
@Entity(name = "stu_info")
public class UserModel {

	// @Id 어노테이션을 사용하여 membId 필드를 기본 키로 지정합니다.
	@Id
	private String membId; // membId를 기본 키로 사용

	private String pass; // 패스워드를 저장하는 필드입니다.

	// 생성자, 게터, 세터 등의 필요한 메서드는 생략합니다.

	// membId 필드의 Getter 메서드입니다.
	public String getMembId() {
		return membId;
	}

	// membId 필드의 Setter 메서드입니다.
	public void setMembId(String membId) {
		this.membId = membId;
	}

	// pass 필드의 Getter 메서드입니다.
	public String getPass() {
		return pass;
	}

	// pass 필드의 Setter 메서드입니다.
	public void setPass(String pass) {
		this.pass = pass;
	}
}