package com.collection.part02_set.hashset;

import java.util.Objects;

public class Member {
	private String name;
	private int age;
	private String phone;
	
	public Member() {}
	public Member(String name, int age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name, phone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)  //주소가 같으면 true
			return true;  
		if (obj == null)  //null이면 false
			return false;
		if (getClass() != obj.getClass())   //클래스 타입 다르면 false
			return false;
		Member other = (Member) obj;      //형변환
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(phone, other.phone); //멤버변수값 비교
	}
	
}
