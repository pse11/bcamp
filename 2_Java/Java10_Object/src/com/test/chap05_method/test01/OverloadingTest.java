package com.test.chap05_method.test01;

public class OverloadingTest {
//	public void test() {
//		System.out.println(1);
//		System.out.println('a');
//		System.out.println("b");
//	}
	
	public int test() {
		return 0;
	}
	public int test(int a) {
		return 0;
	}
	public int test(int a, int b) {
		return 0;
	}
	public int test(int b, String s) {
		return 0;
	}
	
	//오버로딩에서ㅓ 매개변수의 이름은 상관없다. 오로지 타입의 갯수
	//매개변수의 갯수, 타입 순서, 타입이 달라야한다.
//	public int test(int b, int a) {
//		return 0;
//	}
	public int test(String b, int s) {
		return 0;
	}
	
	//static, final키워드는 오버로딩에 영향x
	/*
	 * 
	public final int test(String b, int s) {
	return 0;
	} */
	
	public String test(int a, int b, String s) {
		return null;
	}
	
	//리턴 타입이 다르다고 오버로딩이 적용되지 않는다.
//	public int test(int a, int b, String s) {
	//	return 0;
	//}
	
	//접근제한자가 다르다고 오버로딩이 적용되지 않는다.
	//private String test(int a, int b, String s) {
	//	return null;
	//}
}
