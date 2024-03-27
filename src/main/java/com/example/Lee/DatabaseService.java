package com.example.Lee;

import java.util.List;
import java.util.Map;

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

	public List<Map<String, Object>> getAllDataFromTable(String tableName) {
		// 테이블의 모든 데이터를 가져오는 쿼리 작성
		String sql = "SELECT * FROM " + tableName;

		// JdbcTemplate을 사용하여 쿼리 실행
		List<Map<String, Object>> data = jdbcTemplate.queryForList(sql);

		return data;
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
