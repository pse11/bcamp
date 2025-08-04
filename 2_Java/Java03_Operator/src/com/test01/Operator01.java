package com.test01;

public class Operator01 {
	public static void main(String[] args) {
		//!
		//!true => false, !false => true
		
		System.out.println("!true : " + !true);
		System.out.println("!false : " + !false);
		
		//변수 no의 값이 짝수 인가? 홀수 인가?
		// % 2 == 0 => 짝수
		int no = 33;
		System.out.println("no가 짝수? " + (no%2==0)); //true값이 나오는 경우: no가 짝수
		System.out.println("no가 홀수? " + !(no%2==0));
	}
}
