package com.test02.AOP;

public class Student implements Person{
	
	@Override 
	public void classWork() {
		System.out.println("qr을 찍는다."); //핵심기능
	}
}
