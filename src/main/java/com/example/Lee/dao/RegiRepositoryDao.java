package com.example.Lee.dao;

import org.springframework.data.jpa.repository.JpaRepository; // JPA 리포지토리 기능을 제공하는 스프링 프레임워크의 인터페이스

import com.example.Lee.model.RegiModel; // 회원 등록 모델

// JpaRepository<엔티티 타입, ID 필드 타입>을 상속받음으로써 기본적인 CRUD 및 페이지네이션, 정렬 기능을 사용할 수 있음!
public interface RegiRepositoryDao extends JpaRepository<RegiModel, String> {
	// 학번을 기준으로 기존 등록 여부를 확인하는 메서드
	boolean existsByStdNum(String stdNum);

	// 이메일을 기준으로 기존 등록 여부를 확인하는 메서드
	boolean existsByEmail(String email);

	// 회원 ID를 기준으로 기존 등록 여부를 확인하는 메서드
	boolean existsByMembId(String membId);
}

