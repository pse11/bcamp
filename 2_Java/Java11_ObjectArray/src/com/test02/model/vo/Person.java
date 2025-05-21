package com.test02.model.vo;

public class Person {
	//필드
	private String name;
	private int age;
	private int wealth;
	
	//생성(기본, 매개변수)
	public Person() {}
	public Person(String name, int age, int wealth) {
		this.name=name;
		this.age=age;
		this.wealth=wealth;
	}
	//get&set
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setWealth(int wealth) {
		this.wealth=wealth;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getWealth() {
		return wealth;
	}
	
	//info(필드값 문자열로 리턴)
	public String info() {
		return "name: "+name+",age: "+age+",wealth: "+wealth; 
	}
	
}
