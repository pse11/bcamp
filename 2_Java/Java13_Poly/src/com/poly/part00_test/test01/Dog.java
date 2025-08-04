package com.poly.part00_test.test01;

public class Dog extends Animal { 
	//오버라이딩을 통해 상속받은 위치에서 Animal.bark를 구현해줘야한다.
	
	@Override
	public void bark() {
		//상속받은 클래스에서 반드시 구현
		System.out.println("멍멍");
	}
	
	@Override
	public void eat(String str) {
		System.out.print("강아지가 ");
		super.eat(str);
	}

}
