package com.example.Lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LeeApplication extends SpringBootServletInitializer {

	@Override // 구성 방법 재정의
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LeeApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LeeApplication.class, args);
	}

}
