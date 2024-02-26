package com.test.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex04_select {
	
	public static void main(String[] args) {
		// Ex04.select
		m1();
		
	}//main

	private static void m1() {
		
		// 단일값 반환
		// - 1행 1열
		//Count
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select count(*) from tblAddress";			
			rs = stat.executeQuery(sql);
			
			// ResultSet == 커서(Cursor) > 판독기 == 스트림, Iterator, 향상된 for
			rs.next(); // 커서 1줄 전진
			// 현재 커서가 가르키고 있는 레코드의 원하는 컬럼을 가져오기
			// rs.getXXX()
			
			// 오라클 스타일대로 해야하므로 0번째가 아닌 1번째
			int count = rs.getInt(1);
			System.out.println(count);
			
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex04");
			e.printStackTrace();
		}
		
	}

}
