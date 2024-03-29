package com.test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {
	
	public static void main(String[] args) {
		
		/*
		 *****매우 중요*****
		 JDBC, Java Database Connectivity
		 - 자바 응용 프로그램 <-> JDBC(연결) <-> 오라클 데이터베이스
		 - 중간 계층
		 - 영속성 계층(Persistence Layer)
		 - API > 클래스 집합
		
		 1. JDBC  (2)
		 2. Spring-JDBC (3)
		 3. MyBatis (1)
		 4. JPA
		
		 JDBC Driver 설치
		 - 각 DBMS 홈페이지 > 언어별 제공
		 - Oracle  설치 > 같이 배포 > "obdbc8.jar"
		 - lib 폴더 생성 > ojdbc8.jar > build path > configure build path 설정
		
		 [사람 + SQL Developer <-> Oracle Server]
		 1. 클라이언트 툴 실행
		 2. DB 서버 접속
		 	- 호스트명 : localhost
		 	- 포트번호 : 1521
		 	- SID : xe
		 	- 드라이버 : thin
		 	- 사용자명 : hr
		 	- 암호 : java1234
		 3. 질의
		   - SQL 사용
		   3.1 반환값이 없는 쿼리
		   		- select를 제외한 모든 쿼리
		   		
		   3.2 반환값(결과셋)이 있는 쿼리
		   		- select
		   		- 결과셋을 반환하는 쿼리
		   		- 결과셋을 업무에 사용(***)
		   		
		   4. 접속 종료
		   		- commit/rollback

		 [자바 + JDBC  <- (SQL) -> Oracle Server]
		 1. 자바 응용 프로그램 실행 ( + JDBC )
		
		 2. DB 서버 접속
		 	- JDBC > Connection 클래스 사용
		 	- 호스트명 : localhost
		 	- 포트번호 : 1521
		 	- SID : xe
		 	- 드라이버 : thin
		 	- 사용자명 : hr
		 	- 암호 : java1234
		 3. 질의
		   - SQL 사용
		   - JDBC > Statement 클래스 사용
		   3.1 반환값이 없는 쿼리
		   		- select를 제외한 모든 쿼리
		   		
		   3.2 반환값(결과셋)이 있는 쿼리
		   		- select
		   		- 결과셋을 반환하는 쿼리
		   		- 결과셋을 업무에 사용(***)
		   			> ResultSet 클래스를 반환 > 탐색 > 데이터 사용
		   		
		   4. 접속 종료
		   		- JDBC > Connection 클래스 사용 (연결/해제)
		   		- commit/rollback
		   		
		   		JDBC 라이브러리 클래스
		   		- Connection, Statement, ResultSet 클래스
		
		 // JDBC 토큰
		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
		
		 */
		
		System.out.println("[데이터베이스 접속하기]");
		
		Connection conn = null;  // import java.sql.Connection
		
		// 접속 정보 > 연결 문자열(Connection String)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
		// JDBC 작업 > 외부 입출력 > 예외 처리 필수
		try {
			
			// JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// DB 연결
			// - DB 접속 성공
			// - 접속 정보를 가지고 있는 Connection 객체 반환
			conn = DriverManager.getConnection(url, id, pw);
			
			// 현재 오라클의 접속 상태 확인
			// - 접속 X > true
			// - 접속 O > false
			System.out.println(conn.isClosed());
			
			// 업무 진행 ~ Query!!
			System.out.println("업무 진행");
			
			// 접속 종료
			conn.close();
			
			System.out.println(conn.isClosed());
			
		} catch (Exception e) {
			System.out.println("Ex01.main");
			e.printStackTrace();
		}
		
		
	}//main
}
