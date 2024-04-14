package com.example.Lee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
