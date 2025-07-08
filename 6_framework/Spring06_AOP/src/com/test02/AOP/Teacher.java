package com.test02.AOP;

public class Teacher implements Person{

	@Override
	public void classWork() {
		System.out.println("줌 회의를 시작한다."); //핵심기능
	}

}
