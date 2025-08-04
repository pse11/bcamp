package com.poly.part00_test.test04;

public class Pigeon extends Animal implements Bird{

	@Override
	public void fly() {
		System.out.println("파닥");
	}

	@Override
	public void bark() {
		System.out.println("구구구");
	} //인터페이스 만든뒤 동물의 하위 새, 새에 속한 비둘기 이렇게 만든다.
	
	
}
