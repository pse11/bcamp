package com.poly.part00_test.test07;

public class Profile {
	private String name;
	private String phone;
	
	//생성자 선언
	public Profile(String name, String phone) {
		this.name= name;
		this.phone = phone;
	}
	public void printProfile() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+ phone);
	}
}
