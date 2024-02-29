package com.test.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.board.model.BoardDTO;
import com.test.main.DBUtil;

public class BoardDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	// 트랜잭션 자동용 
	public BoardDAO() {
		
		conn = DBUtil.open("localhost", "jdbc", "java1234");
	}
	// 트랜잭션 수동용
	public BoardDAO(boolean flag) {
		
		conn = DBUtil.open("localhost", "jdbc", "java1234");
		if (flag) {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// DAO 에서는 하나의 메서드 안에서 하나의 쿼리만 날린다. > 포인트 누적 메서드 따로 만들기
	public int add(BoardDTO dto) {
		
	try {
		
		String sql = "insert into tblBoard values (seqBoard.nextVal, ?, ?, default, ?)";
		
		pstat = conn.prepareStatement(sql);
		
		pstat.setString(1, dto.getSubject());
		pstat.setString(2, dto.getContent());
		pstat.setString(3, dto.getId());
		
		pstat.executeUpdate(); // 1, 0 성공, 실패
		
	} catch (Exception e) {
		System.out.println("BoardDAO.add");
		e.printStackTrace();
	}
		
		
		return 0;
		
		
	}
	
	public ArrayList<BoardDTO> list() {
		
		try {
			
			String sql = "select * from tblBoard order by seq desc";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			// ResultSet > 일반 자바 코드
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			// rs > (복사) > List
			while (rs.next()) {
				// 1회전 > 레코드  1줄 > BoardDTO 1개
				BoardDTO dto = new BoardDTO();
				
				// 1:1 복사..
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}//while > 복사 완료
			
			return list;
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int addPoint(String auth) {
		
		try {
			String sql = "update tblUser set point = point + 100 where id = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, auth);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void commit() {
		try {
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		
		
		try {
			conn.rollback();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
