package com.test04.AOP_anno;

public class Student implements Person{

	@Override
	public String classWork() {
		System.out.println("qr을 찍는다.");
		return "스프링";
	}

}
