package com.mlp.dto;

import java.util.Date;

public class BoardDto {
	private int no;
	private String writer;
	private String title;
	private String content;
	private String keyword;
	private String release;
	private Date regDate;
	public BoardDto() {	}
	public BoardDto(int no, String writer, String title, String content, String keyword, String release, Date regDate) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.keyword = keyword;
		this.release = release;
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
