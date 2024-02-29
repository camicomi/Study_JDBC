package com.test.board.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	// DTO 1 개 == 레코드 1개 >> 배열, 컬렉션으로 만들면 표가 됨
	
	private String seq;
	private String subject;
	private String content;
	private String id;
	private String regdate;

}
