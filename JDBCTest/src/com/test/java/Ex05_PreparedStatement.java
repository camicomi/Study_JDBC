package com.test.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Ex05_PreparedStatement {
	
	public static void main(String[] args) {
		
		//Ex05_PreparedStatement.java
		
		// PreparedStatement
		// - 매개변수 지원
		// - Statement > 정적 SQL
		// - PrepareadStatement > 동적 SQL
		
		// insert
		String name = "하하하";
		String age = "25";
		String gender = "m";
		String tel = "010-1234-5678";
		String address = "서울시 강동구 천호동";
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		try {
			conn = DBUtil.open();
			
//			// 1. Statement 사용
//			stat = conn.createStatement();
			// 객체 생성 > 쿼리 
//			
//			String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);
//			int result = stat.executeUpdate(sql);
//			System.out.println(result);
			
			// 2. PreparedStatement
			// 최소 1개 이상의 인자값 요구
			// 객체 생성과 동시에 쿼리 미리 요구
			// - ? : 오라클의 매개변수
			// 숫자, 문자 상관없이 ? (홑따옴표X) 
			String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)", name, age, gender, tel, address);
			pstat = conn.prepareStatement(sql);
			
			// ? 채우기
//			pstat.setXXX();
			// 자료형은 자바 자료형이므로 String, 물음표 순서 오라클이므로 1부터 시작
			pstat.setString(1, name);
			pstat.setString(2, age);
			pstat.setString(3, gender);
			pstat.setString(4, tel);
			pstat.setString(5, address);
			
			// 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1 >> 첫번째 ? 에서 에러가 났다는 의미 >> ? 값을 넘기려면?
			int result = pstat.executeUpdate();
			
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
