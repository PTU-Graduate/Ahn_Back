package com.example.Lee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/test")
	public String test() {
		return "아령하세옹~ 이종태입니다...?";
	}
}
