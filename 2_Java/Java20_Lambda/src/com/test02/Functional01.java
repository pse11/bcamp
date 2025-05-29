package com.test02;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Functional01 {

	public static void main(String[] args) {
		//unaryTest();
		binaryTest();

	}
	public static void unaryTest() {
		//UnaryOperator라는 함수형 인터페이스 활용
		//apply()를 호출하여 작업 수행
		UnaryOperator<String> hello = name->"Hello, "+name; //지정해준 타입과 동일한 타입으로 리턴
		
		System.out.println(hello.apply("Lambda"));
	}
	public static void binaryTest() {
		//BinaryOperator라는 함수형 인터페이스
		BinaryOperator<Integer> sum = (i,j)->i+j;
		System.out.println(sum.apply(5,3));
	}

}
