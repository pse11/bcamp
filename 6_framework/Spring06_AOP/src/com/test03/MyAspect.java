package com.test03;

public class MyAspect {
	//공통관심사항을 메소드 단위로 분리
	public void before() {
		System.out.println("컴퓨터를 켠다.");
	}
	public void after() {
		System.out.println("집에 간다.");
	}

}
