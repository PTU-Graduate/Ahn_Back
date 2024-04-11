package com.example.Lee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Lee.dao.LoginDao;
import com.example.Lee.model.UserModel;

//이 클래스를 서비스로 지정합니다.
@Service
public class LoginService {

	private final LoginDao loginDao; // LoginDao 의존성 주입을 위한 필드

	// 생성자를 통해 LoginDao 의존성을 주입받습니다.
	@Autowired
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	// 사용자 인증을 수행하는 메서드입니다.
	public String authenticateUser(String membId, String pass) {
		// 사용자 정보를 데이터베이스에서 조회합니다.
		UserModel user = loginDao.findByMembId(membId);

		// 사용자가 존재하지 않는 경우
		if (user == null) {
			return "02"; // 아이디 오류 메시지 반환
		}

		// 비밀번호가 일치하지 않는 경우
		if (!user.getPass().equals(pass)) {
			return "01"; // 비밀번호 오류 메시지 반환
		}

		// 모든 조건을 만족하는 경우
		return "00"; // 성공 메시지 반환
	}
}