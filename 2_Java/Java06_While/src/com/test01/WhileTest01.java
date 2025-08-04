package com.test01;

import java.util.Scanner;

public class WhileTest01 {
	public static void main(String[] args) {
		//testWhile1();
		//testWhile2();
		//testWhile3();
		//testWhile4();
		testWhile5();
	}
	
	public static void testWhile1() {
		int i=1;
		while(i<20) {
			System.out.println(i+"번째 반복중");
			i+=2;
		}
		System.out.println("while 종료 후 i값: " +i );
	}
	public static void testWhile2() {
		//문자열을 입력 받아 문자를 인덱스별로 문자 출력
		//charAt();
		Scanner sc = new Scanner(System.in)	;
		System.out.print("문자열 입력: ");
		String input = sc.next();

		int index=0;
		while(index<input.length()) {
			char ch = input.charAt(index);
			System.out.println(index+":"+ch);
			index++;
		} 
		//js에서 array.length : 변수, java에서 length(): 기능
	}
	public static void testWhile3() {
		//1부터 입력받은 수까지 정수들의 합
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력:" );
		int input = sc.nextInt();
		int i=1;
		int sum=0;
		while(i<=input) {
			sum+=i;
			i++;
		}
		System.out.println("sum: "+sum);
	}
	public static void testWhile4() {
		Scanner sc = new Scanner(System.in);
		int i=1;
		while(true) {
			System.out.println(i);
			i++;
			if(i==10) {
				break;
			}
		}
		
		//키보드로 4를 입력 받을 때까지 반복
		//4 입력하면 while문 종료
		while(true) {
			System.out.print("정수입력:");
			String num = sc.next();
			if(num.equals("4")) { //string은 참조형이기 때문에 비교연산자를 활용할 수 없다.
				System.out.println("4입력! 종료!");
				break;
			}
		}
		
	}
	public static void testWhile5() {
		int no1 = 1;
		while(no1<10) {
			int no2 = 10;
			while(no2<15) {
				System.out.println("no1:"+no1+", no2: "+no2);
				no2++;
			}
			System.out.println();
			no1++;
		}
		//구구단 2~9단까지 출력
		int m1 = 2;
		while(m1<10) {
			int m2 = 1;
			while(m2<10) {
				System.out.println(m1+"x"+m2+"="+m1*m2);
				m2++;
			}
			System.out.println();
			m1++;
		}
	}
}


