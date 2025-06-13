package com.test02.model;

public class MyTestDto { //객체 만들어서 DB에 저장된 데이터를 불러와서 저장 
	private int mno;
	private String mname;
	private String nickName;
	public MyTestDto() {}
	public MyTestDto(int mno, String mname, String nickName) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.nickName = nickName;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "[mno=" + mno + ", mname=" + mname + ", nickName=" + nickName + "]";
	}
	
}
