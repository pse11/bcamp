package com.silsub1;

public class Trader {
	//-field : private String name;
//    private String city;
//-method : 생성자(기본,매개변수), getter, toString
	private String name;
	private String city;
	public Trader() {}
	public Trader(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "name=" + name + ", city=" + city;
	}
	
}
