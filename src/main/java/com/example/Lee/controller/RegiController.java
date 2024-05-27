package com.example.Lee.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired; // 스프링의 의존성 주입 기능을 위한 어노테이션
import org.springframework.http.ResponseEntity; // HTTP 응답을 캡슐화하는 클래스
import org.springframework.web.bind.annotation.PostMapping; // POST 요청을 처리하는 메소드를 위한 어노테이션
import org.springframework.web.bind.annotation.RequestBody; // HTTP 요청 본문을 메소드 파라미터로 바인딩하는 어노테이션
import org.springframework.web.bind.annotation.RestController; // REST 컨트롤러임을 나타내는 어노테이션

import com.example.Lee.model.CommonResponseModel; // 공통 응답 모델 클래스
import com.example.Lee.model.RegiModel; // 회원 등록 정보 모델 클래스
import com.example.Lee.service.RegiService; // 회원 등록 서비스 클래스

@RestController // 이 클래스가 REST 컨트롤러로 동작함을 스프링에게 알림
public class RegiController {

	private final RegiService regiService; // 회원 등록 서비스 객체

	@Autowired // 의존성 자동 주입. 스프링이 RegiService 타입의 객체를 자동으로 주입
	public RegiController(RegiService regiService) {
		this.regiService = regiService; // 생성자를 통해 주입받은 서비스 객체를 필드에 할당
	}

	@PostMapping("/PTU/register") // "/PTU/register" 경로로 POST 요청을 받음
	public ResponseEntity<CommonResponseModel> register(@RequestBody Map<String, String> requestData) {
		// 회원 정보를 담는 RegiModel 객체 생성
		RegiModel regiData = new RegiModel();
		// 요청 데이터에서 회원 정보를 추출하여 RegiModel 객체에 설정
		regiData.setPass(requestData.get("PASS"));
		regiData.setStdDepCd(requestData.get("STD_DEP_CD"));
		regiData.setName(requestData.get("NAME"));
		regiData.setEmail(requestData.get("EMAIL"));

		// 서비스를 호출하여 회원 등록 처리 후 결과를 받음
		CommonResponseModel result = regiService.registerUser(regiData);

		// 결과를 ResponseEntity로 감싸 클라이언트에 반환
		return ResponseEntity.ok(result);
	}
}
