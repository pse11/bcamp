package com.my.dto;

import java.util.Date;

public class MyBoard {
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private Date mydate;
	public MyBoard() {
		super();
	}
	public MyBoard(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}
	public String getMycontent() {
		return mycontent;
	}
	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}
	public Date getMydate() {
		return mydate;
	}
	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	//toString은 여기서 사용할 필요없다. -> 콘솔에서 출력하는게 아니니까. 
	//확인용으로 사용할 수는 있다.
}
