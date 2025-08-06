package com.mlp.dto;

import java.util.Date;

public class ReplyDto {
	private int no;
	private int cno;
	private String id;
	private String name;
	private String reply;
	private Date cdate;
	public ReplyDto() {
	}
	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public ReplyDto(int no, int cno, String id, String name, String reply, Date cdate) {
		super();
		this.no = no;
		this.cno = cno;
		this.id = id;
		this.name = name;
		this.reply = reply;
		this.cdate = cdate;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	
}
