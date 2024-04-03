package com.example.Lee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lee.service.DatabaseService;

@RestController
public class HelloController {

	private final DatabaseService databaseService;

	@Autowired
	public HelloController(DatabaseService databaseService) {
		this.databaseService = databaseService;
	}

	@GetMapping("/test")
	public String test() {
		return "너는이종태다 키";
	}

	@GetMapping("/DbTest")
	public List<Map<String, Object>> dbTest(@RequestParam(required = false) String endpoint,
			@RequestParam(required = false) String data) {
		System.out.println("Endpoint: " + endpoint);

		// stu_info 테이블의 모든 데이터 반환
		return databaseService.getAllDataFromTable("stu_info");
	}
}
