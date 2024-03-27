package com.example.Lee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public DatabaseService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initialize() {
		boolean isConnected = isDatabaseConnected();
		if (isConnected) {
			System.out.println("데이터베이스 연결됨");
		} else {
			System.out.println("데이터베이스 연결 실패");
		}
	}

	private boolean isDatabaseConnected() {
		try {
			jdbcTemplate.execute("SELECT 1");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
