package com.example.Lee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lee.service.DatabaseService;

@RestController
public class HelloController {

	private final DatabaseService databaseService;

	@Autowired
	public HelloController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@PostMapping("/test")
	public String test() {
		return "너는이종태다 키";
	}

	@PostMapping("/DbTest")
	public List<Map<String, Object>> dbTest(@RequestBody Map<String, String> requestData) {
		String endpoint = requestData.get("endpoint");
		String data = requestData.get("data");
		System.out.println("Endpoint: " + endpoint);
		

		// stu_info 테이블의 모든 데이터 반환
		return databaseService.getAllDataFromTable("stu_info");
	}
}
