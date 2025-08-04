package com.test02;

public class Test {
	public void test01(int no) {
		String result=(no%5==0)?"5의 배수입니다.":"5의 배수가 아님";
		System.out.println(result);
	}
	public void test02(int no) {
		String result="";
		if(no%2==0&&no%3==0) {
			result="2와 3의 배수입니다.";
		}else {
			result="2와 3의 배수가 아닙니다.";
		}
		System.out.println(result);
	}
	public void test03(char ch) {
		if(Character.isUpperCase(ch)) {
			System.out.println("대문자입니다.");
		}else {
			System.out.println("소문자입니다");
		}
	}
}
