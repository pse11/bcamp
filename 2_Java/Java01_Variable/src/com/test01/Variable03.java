package com.test01;

public class Variable03 {
	public static void main(String[] args) {
		//상수
		int age;
		final int AGE;
		
		age = 20;
		AGE = 50;
		
		System.out.println(age);
		System.out.println(AGE);
		
		//값 변경
		age = 30;
		//AGE = 60; 에러 발생
		
		final double PI = 3.141592;
		
		//오버플로우
		//byte bnum = 128;
		//에러, 범위를 벗어난 값 저장 불가능
		
		//계산과정에서 범위를 벗어나면 오버플로우 처리된다.
		byte bnum = 127;
		bnum++;
		//값이 순환된다.
		System.out.println(bnum); //-128
		
		
	
	}
}
