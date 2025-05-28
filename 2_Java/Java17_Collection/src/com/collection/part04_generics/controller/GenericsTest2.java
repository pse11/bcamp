package com.collection.part04_generics.controller;

public class GenericsTest2<T> {
	//클래스에 제네릭스 선언
	//GenericsTest 는 컬렉션안에 제네릭스 선언한 것이다.
	private T[] array;
	
	public GenericsTest2() {}
	
	public GenericsTest2(T[] array) {
		this.array=array;
	}
	public void prn() {
		for(T tmp:array) {
			System.out.println(tmp);
		}
	}
}
