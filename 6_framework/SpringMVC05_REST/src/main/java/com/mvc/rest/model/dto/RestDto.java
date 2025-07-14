package com.mvc.rest.model.dto;

public class RestDto {
/*
CREATE TABLE RESTBOARD(
	RESTNO NUMBER PRIMARY KEY,
	RESTID VARCHAR2(2000) NOT NULL,
	RESTPW VARCHAR2(2000) NOT NULL,
	RESTNAME VARCHAR2(500) NOT NULL
);
CREATE SEQUENCE SEQ_REST NOCACHE;

INSERT INTO RESTBOARD VALUES(SEQ_REST.NEXTVAL, 'admin','1234','관리자');

SELECT * FROM RESTBOARD;
 */
	private int restno;
	private String restid;
	private String restpw;
	private String restname;
	public RestDto() {}
	
	public RestDto(int restno, String restid, String restpw, String restname) {
		super();
		this.restno = restno;
		this.restid = restid;
		this.restpw = restpw;
		this.restname = restname;
	}
	public int getRestno() {
		return restno;
	}
	public void setRestno(int restno) {
		this.restno = restno;
	}
	public String getRestid() {
		return restid;
	}
	public void setRestid(String restid) {
		this.restid = restid;
	}
	public String getRestpw() {
		return restpw;
	}
	public void setRestpw(String restpw) {
		this.restpw = restpw;
	}
	public String getRestname() {
		return restname;
	}
	public void setRestname(String restname) {
		this.restname = restname;
	}
	
}
