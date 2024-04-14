package com.example.Lee.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lee.service.LoginService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST })
public class LoginController {
	private final LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/Login")
	public String Login(@RequestBody Map<String, String> requestData) {
		String loginId = requestData.get("MEMB_ID");
		String loginPass = requestData.get("PASS");

		if (loginId == null || loginId.isEmpty() || loginPass == null || loginPass.isEmpty()) {
			throw new IllegalArgumentException("LOGIN_ID와 LOGIN_PASS를 제대로 입력하세요.");
		}

		// 패스워드가 비어있는 경우 IllegalArgumentException을 발생시킴
		if (loginPass.isEmpty() || loginId.isEmpty()) {
			throw new IllegalArgumentException("LOGIN_PASS를 제대로 입력하세요.");
		}

		return loginService.authenticateUser(loginId, loginPass);
	}
}
