package com.test01;

import java.util.Scanner;

public class SwitchTest01 {
	/*switch(조건){
	 * case 값1:
	 * case 값2:
	 */
	public void test1() {
		int no = 2;
		
		switch(no) {
			case 1: 
				System.out.println("1입니다.");
				break;
			case 2: 
				System.out.println("2입니다.");
				break;
			case 3: 
				System.out.println("3입니다.");
				break;
			default:
				System.out.println("다른 숫자입니다.");
		}
		char ch = 'e';
		switch(ch) {
		case 'a':
			System.out.println("a입니다");
			break;
		case 'b':
			System.out.println("b입니다");
			break;
		case 'c':
			System.out.println("c입니다");
			return;
		default:
				System.out.println("다른 영어입니다");
				
		}
		//return : 실행되고 있는 메소드 종료
	}
	public void test2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("month 입력: ");
		String month = sc.next();
		
		switch(month) {
		case "1":
		case "3":
		case "5":	//break없기 때문에 동일한 처리하는 코드 하나 남기고 작성한다.
		case "7":
		case "8":	
		case "10":	
		case "12":
			System.out.println("31일 까지 있는 달입니다.");
			break;	
		case "2":
			System.out.println("28/29일 까지 있는 달입니다.");
			break;
		case "4":
		case "6":
		case "9":
		case "11":
			System.out.println("30일 까지 있는 달입니다.");
			break;
		}
	}
}
