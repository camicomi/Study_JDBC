package com.test.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class Ex06_CallableStatement {
	
	public static void main(String[] args) {
		
		//m1();
		// m2();
		// m3();
		// m4();
		m5();
		
		
		
	}//main

	private static void m5() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = " { call procM5(?, ?) }";
			
			stat = conn.prepareCall(sql);
			
			// in
			stat.setString(1, "영업부");
			// out 테이블이 다 들어있는데,,  
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			// out > 오라클 커서 == 결과셋 == JDBC ResultSet
			
			rs = (ResultSet)stat.getObject(2);
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement");
			e.printStackTrace();
		}
		
	}

	private static void m4() {
		
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM4(?, ?, ?, ?, ?) }";
			
			stat = conn.prepareCall(sql);
			
			// in
			stat.setString(1, "1001");
			
			// out 단일값.. 
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			stat.registerOutParameter(4, OracleTypes.VARCHAR);
			stat.registerOutParameter(5, OracleTypes.VARCHAR);
			
			
			stat.executeQuery();
			
			// 인덱스밖에 못한..
			System.out.println(stat.getString(2));
			System.out.println(stat.getString(3));
			System.out.println(stat.getString(4));
			System.out.println(stat.getString(5));
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement");
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		
			Connection conn = null;
			CallableStatement stat = null;
			ResultSet rs = null;
			
			try {
				
				conn = DBUtil.open();
				
				// in, out  상관없이 > ?
				String sql = "{ call procM3(?) }";
				
				stat = conn.prepareCall(sql);
				
				// in parameter
				// stat.setString(1, 값);
				
				// out parameter
				// (index, sql type)
				// 만약 OracleTypes. 안되면 info 파일 삭제
				stat.registerOutParameter(1, OracleTypes.NUMBER);
				
				// 프로시저 할 때는 rs 안받는다 
				
				stat.executeQuery(); 
				// PLSQL 문에서 인출을 수행할 수 없습니다 : next
				// System.out.println(rs.next());
				
				int count = stat.getInt(1);
				System.out.println(count);
			
				conn.close();
				
			} catch (Exception e) {
				System.out.println("Ex06_CallableStatement");
				e.printStackTrace();
			}
		
		
	}

	private static void m2() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
	
			String sql = "{ call procM2(?, ?, ?, ?, ?)}";
			
	
			stat = conn.prepareCall(sql); 
			
			stat.setString(1, "후후후");
			stat.setString(2, "22");
			stat.setString(3, "m");
			stat.setString(4, "010-3213-3212");
			stat.setString(5, "서울시");

			int result = stat.executeUpdate();
			System.out.println(result);
			
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement");
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void m1() {
		
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			//  프로시저 호출 
			String sql = "{ call procM1 }";
			
			// PreparedStatement 사용법과 99% 동일
			stat = conn.prepareCall(sql); // 매개변수 처리 기능 보유
			
			// 반환값이 없으니깐 executeUpdate
			int result = stat.executeUpdate();
			System.out.println(result);
			
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement");
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	// 복사용 
	private static void temp() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement");
			e.printStackTrace();
		}
	}
}
