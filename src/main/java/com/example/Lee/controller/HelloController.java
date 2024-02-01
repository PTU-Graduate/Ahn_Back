package com.example.Lee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/test")
	public String test() {
		return "히히 고쳤쥬 히히 고쳤즁?? 고쳤쥬~~";
	}
}
