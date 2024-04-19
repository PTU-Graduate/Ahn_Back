package com.example.Lee.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Lee.dao.LoginDao;
import com.example.Lee.model.LoginRsltModel;
import com.example.Lee.model.UserModel;

@Service
public class LoginService {

	private final LoginDao loginDao;

	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public ResponseEntity<LoginRsltModel> authenticateUser(String membId, String pass) {
		// 데이터베이스에서 해당 MEMB_ID에 대한 정보 조회
		UserModel user = loginDao.findByMembId(membId);

		// MEMB_ID가 존재하지 않는 경우
		if (user == null) {
			return ResponseEntity.ok(new LoginRsltModel("02"));
		}

		// MEMB_ID에 해당하는 PASS와 비교하여 인증 수행
		if (!user.getPass().equals(pass)) {
			return ResponseEntity.ok(new LoginRsltModel("01"));
		}

		// 인증 성공
		return ResponseEntity
				.ok(new LoginRsltModel("00", user.getStdNum(), user.getStdDepCd(), user.getName(), user.getGrade()));
	}
}
