package com.test03.aop_config;

public class Test implements Person{

	@Override
	public void classWork() {
		System.out.println("테스트..");
	}
	
	public void test() {
		System.out.println("test() call");
	}

}
