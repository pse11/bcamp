package com.test01;

public class WhileTest03 {
	public static void main(String[] args) {
		//1. 1~100까지 숫자를 출력. 단 역순으로
		WhileTest03.prn01();
		//2. 1~100까지의 숫자 중, 2의 배수만 출력
		WhileTest03.prn02();
		//3. 1~100까지의 숫자 중, 7의 배수의 갯수와 총 합을 출력
		WhileTest03.prn03();
	}
	public static void prn01() {
		int i = 100;
		while(i>=1) {
			System.out.println(i);
			i--;
		}
	}
	public static void prn02() {
		int i=1;
		while(i<=100) {
			if(i%2==0) {
				System.out.println(i);
			}
			i++;
		}
	}
	public static void prn03() {
		int i=1;
		int sum=0;
		int count =0;
		do {
			if(i%7==0) {
				count++;
				sum+=i;
			}
			i++;
		}while(i<=100);
		System.out.println("sum:"+sum+",count:"+count);
	}
}
