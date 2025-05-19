package com.test01;

import java.util.Scanner;

public class SwitchTest02 {
	public void test1() {
		//정수 두개와 연산기호를 문자로 입력받아
		//입력받은 연산기호에 해당하는 계산을 수행하고 출력
		// 3 4 + => 3+4
		System.out.print("정수 두개, 연산기호");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		char op = sc.next().charAt(0);
		
		switch(op) {
		case '+':
			System.out.printf("%d %c %d = %d",num1,op,num2,num1+num2);
			break;
		case '-':
			System.out.printf("%d %c %d = %d",num1,op,num2,num1-num2);
			break;
		case '*':
			System.out.printf("%d %c %d = %d",num1,op,num2,num1*num2);
			break;
		case '/':
			System.out.printf("%d %c %d = %d",num1,op,num2,num1/num2);
			break;
		case '%':
			System.out.printf("%d %c %d = %d",num1,op,num2,num1%num2);
			break;
		}
		
	}
}
