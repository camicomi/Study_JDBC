package com.test.member.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// DTO , Data Transfer Object
// - 계층간 데이터를 전달하는 용도(상자)

// lombok
// @Getter
// @Setter

// Getter + Setter + ToString 
@Data
public class MemberDTO {
	
	// 전달할 변수만 넣으면 끝
	
	private String id;
	private String pw;
	
	
	// 입출력을 위해 getter, setter 생성
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getPw() {
//		return pw;
//	}
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
	
	

}
