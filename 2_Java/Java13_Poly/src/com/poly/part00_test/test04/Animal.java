package com.poly.part00_test.test04;

public abstract class Animal {
	public abstract void bark(); //추상메소드
	
	public void eat(String str) { //일반메소드
		System.out.println(str+" 먹는다.");
	}
}
