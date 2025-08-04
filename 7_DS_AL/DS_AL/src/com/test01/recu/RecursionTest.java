package com.test01.recu;

import java.util.Scanner;

public class RecursionTest {//재귀
	//팩토리얼 함수 구현
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 입력: ");
		int no = sc.nextInt();
		//1. for문
		int res = 1;
		for(int i=2;i<=no;i++) {
			res*=i;
		}
		System.out.println("결과: "+res);
		
		//------------------------------
		//2. 재귀함수
		System.out.println("결과: "+factorial(no));
	}
	//2. 재귀 함수 구현
	public static int factorial(int no) {
		/*if(no==1) {return 1;} //재귀함수 종료 조건
		else {
			return no*factorial(no-1);
		}
		*/
		return (no==1)?1:no*factorial(no-1);
	}
	
}
