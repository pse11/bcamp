package com.collection.silsub1.model.vo;

import java.io.Serializable;
import java.util.Date;

//vo(Value Object) or dto(Data Transfer Object)
//-> 보통 두개 같은 거라고 생각한다.
public class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5716539748787584395L;
	
	//게시글
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private Date boardDate;
	private String boardContent;
	
	public Board() {}

	public Board(int boardNo, String boardTitle, String boardWriter, Date boardDate, String boardContent) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "번호:" + boardNo + "/ 제목: " + boardTitle + "/ 작성자: " + boardWriter
				+ "/ 작성일: " + boardDate + "/ 내용: " + boardContent;
	}
}
