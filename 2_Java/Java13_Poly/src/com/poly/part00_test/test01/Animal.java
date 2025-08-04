package com.poly.part00_test.test01;

//추상클래스
public abstract class Animal { //abstract를 넣지 않으면 그냥 일반 클래스다.
	//추상 메소드는 상속받는 class가 반드시 구현
	public abstract void bark(); //몸체 없는 메소드. 선언부만 존재한다.

	public void eat(String str) { //일반적인 메소드 선언 가능하다.
		System.out.println(str+"먹는다.");
	}
}
