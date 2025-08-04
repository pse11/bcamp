package com.test05;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;
	public Member() {
	}
	public Member(String id, String pw, String name, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "id: " + id + "\t pw: " + pw + "\t name: " + name + "\t phone: " + phone;
	}
	
	
}
