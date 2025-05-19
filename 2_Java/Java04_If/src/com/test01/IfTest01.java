package com.test01;

import java.util.Scanner;

public class IfTest01 {
	Scanner sc = new Scanner(System.in);
	//필드, 멤버변수, 전역변수
	public void testIf() {
		//단독 if문
		//조건식의 결과가 참이면 {}안에 코드 실행
		//조건식의 결과가 거짓이면 {}안에 있는코드를 무시하고 건너띄기.
		
		int num = 10;
		
		//짝수인지 확인
		if(num%2==0) {
			System.out.println("입력하신 숫자는 짝수 입니다.");
		}
		//짝수가 아닌 경우
		if(num%2 != 0) {
			System.out.println("입력하신 숫자는 홀수 입니다.");
		}
		System.out.println("프로그램 종료");
	}
	public void testIfElse() {
		//else : 조건식을 사용 X. if의 조건식이 거짓이면 무조건 else의 {}안에 코드가 실행
		int num = 12;
		if(num%2==0) {
			System.out.println("입력하신 숫자는 짝수입니다.");
		}else {
			System.out.println("입력하신 숫자는 홀수입니다.");
		}
	}
	public void testIfElse2() {
		//정수를 하나 입력받아(Scanner)
		//50보다 큰 수일때 짝수인지 홀수인지 출력.
		//50보다 작은 수라면 "작다" 라고 출력
		
		System.out.print("num:");
		int num=sc.nextInt();
		/*
		if(num >= 50) {
			//System.out.println("크다");
			if(num%2==0) {
				System.out.println("짝수");
			}else {
				System.out.println("홀수");
			}
		} else{
			System.out.println("작다");
		}
		*/
		//이 if문을 삼항연산자로 작성
		String res = (num>=50)?(num%2==0?"짝수":"홀수"):"작다";
		System.out.println(res);
	}
	public void testIfElse3() {
		//정수 하나를 입력 받아 양수인지 음수인지 출력
		//단, 0이면 "0입니다"라고 출력
		
		System.out.print("정수 입력:");
		int inputNum = sc.nextInt();
		/*내 답
		if(inputNum>=0) {
			if(inputNum==0){
				System.out.println("0입니다");
			}else {
				System.out.println("양수");
			}
		}else {
			System.out.println("음수");
		}
		*/
		//강사님 답
		if(inputNum!=0) {
			if(inputNum>0) {
				System.out.println("양수");
			}else {
				System.out.println("음수");
			}
		}else{
			System.out.println("0");
		}
	}
	public void testIfElse4() {
		//정수 두 개를 입력 받는다.
		//입력받은 두 수의 산술연산을 처리하여 출력한다.(+,-,*,/,%)
		//단, 두 수 모두 반드시 1부터 100사이 값이어야 한다.
		//둘 중 하나라도 범위에 속하지 않은 수라면 
		//"값은 1부터 100사이어야 합니다"라고 출력.
		
		System.out.print("정수 두 개입력:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>=1&&a<=100&&b>=1&&b<=100) {
			System.out.println(a+"+"+b+"="+(a+b));
			System.out.println(a+"-"+b+"="+(a-b));
			System.out.println(a+"*"+b+"="+(a*b));
			System.out.println(a+"/"+b+"="+(a/b));
			System.out.println(a+"%"+b+"="+(a%b));
		}else {
			System.out.println("값은 1부터 100사이어야합니다.");
		}
		
	}
}
