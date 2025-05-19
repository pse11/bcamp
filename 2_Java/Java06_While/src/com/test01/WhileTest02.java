package com.test01;

import java.util.Scanner;

public class WhileTest02 {
	public static void main(String[] args) {
		//WhileTest02.testDoWhile1();
		//WhileTest02.testDoWhile2();
		WhileTest02.testDoWhile3();
	}
	public static void testDoWhile1() {
		int i=1;
		do {
			System.out.println(i);
			i++;
		}while(i<=10); //10까지 출력됨
		System.out.println("do while 종료 후 i: "+i);
		
		//이 시점에서 i=11
		do {
			System.out.println(i);
			i++;
		}while(i<=10);
		//일단 한번은 실행되기 때문에 i=12가 된다. while과의 차이점이다.
		System.out.println("do while 종료 후 i: "+i);
	}
	public static void testDoWhile2() {
		//키보드로 영어 문자열값을 입력 받아 출력 반복.
		//단, exit입력할때까지
		Scanner sc = new Scanner(System.in);
		String input ="";
		do {
			System.out.print("문자열 입력: ");
			input = sc.next();
			System.out.println(input);
		}while(!input.equals("exit")); //조건 만족하면 반복이니까 while안에 exit가 아니면을 넣어야함! string은 equals로 비교
	}
	public static void testDoWhile3() {
		//testDoWhile2와 동일하게 동작하도록 구현
		Scanner sc = new Scanner(System.in);
		String input = "";
		do {
			System.out.print("문자열 입력: ");
			input = sc.next();
			if(input.equals("exit")) {
				System.out.println("종료!");
				break;
			}
			System.out.println("input: "+input);
		}while(true);
	}
}