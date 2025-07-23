package com.mlp.dto;

import java.util.Date;

/*
 * CREATE SEQUENCE SEQ_COMMENT NOCACHE;
DROP TABLE MLPCOMMENT;
CREATE TABLE MLPCOMMENT(
	NO NUMBER PRIMARY KEY,
	BOARDNO NUMBER NOT NULL,
	ID VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(2000),
	CDATE DATE NOT NULL
);
 */
public class CommentDto {
	private int no;
	private int boardno;
	private String id;
	private String content;
	private String name;
	private Date cdate;
	public CommentDto() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CommentDto(int no, int boardno, String id, String content, String name, Date cdate) {
		super();
		this.no = no;
		this.boardno = boardno;
		this.id = id;
		this.content = content;
		this.name = name;
		this.cdate = cdate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
}

