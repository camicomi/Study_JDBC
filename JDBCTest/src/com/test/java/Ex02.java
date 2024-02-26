package com.test.java;

import java.sql.Connection;

public class Ex02 {

	public static void main(String[] args) {

		// 접속 시 발생하는 에러

		// 1. 서버 주소가 틀렸을 경우

		// - IO 오류: The Network Adapter could not establish the connection

		// 예) Connection conn = DBUtil.open("192.168.10.99", "hr", "java1234");

		// 2. 계정 아이디 또는 암호가 틀렸을 경우

		// - ORA-01017: 사용자명/비밀번호가 부적합, 로그온할 수 없습니다.

		// 예) Connection conn = DBUtil.open("localhost", "hr2", "java1234");

		// 3. 서버 중지 (service.msc)

		// - Listener refused the connection with the following error:

		// 4. 연결문자열 오타

		// - 부적합한 Oracle URL이 지정되었습니다.

		// - 예) DBUtil.class > String url = "jdbc:oracle:thin@" + host + ":1521:xe";

		// 5. 포트 번호 오타

		// - IO 오류: The Network Adapter could not establish the connection

		// - 예) DBUtil.class > String url = "jdbc:oracle:thin@" + host + ":1520:xe";

		// 6. SID 오타 (xe)

		// - Listener refused the connection with the following error:

		// - 예) DBUtil.class > String url = "jdbc:oracle:thin@" + host + ":1521:xa";

		// 7. 드라이브 오타

		// - oracle.jdbcdriver.OracleDriver

		// - 예) Class.forName("oraclejdbc.driver.OracleDriver");

		// 8. ojdbc8.jar 문제

		// - oracle.jdbc.driver.OracleDriver

		try {

			// Connection conn = DBUtil.open();

			// Connection conn = DBUtil.open("localhost", "hr", "java1234");

			Connection conn = DBUtil.open("localhost", "hr", "java1234");

			System.out.println(conn.isClosed());

			conn.close();

		} catch (Exception e) {

			System.out.println("Ex02.main");

			e.printStackTrace();

		}

	}

}