package com.test01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Variable02 { //오로지 class 안에는 메소드 선언, 변수 선언, 다른 클래스만 가능
	public static void main(String[] args) {
		//test1 메소드 가져올 준비
		Variable02 test = new Variable02();
		//실행
		test.test1();
		//상단의 버튼 클릭, ctrl+f11
	}
	
	public void test1() {
		//콘솔창으로 부터 키보드로 값 입력받기
		//Scanner 클래스 이용
		
		//준비
		//다른 패키지의 클래스 사용
		//1. java.util.Scanner sc = new java.util.Scanner(System.in);
		
		//2.import
		Scanner sc = new Scanner(System.in);
		
		//실행
		//sc.nextInt();
		System.out.println("이름 입력하세요: ");
		String name = sc.nextLine(); //nextLine(문자열 받아오는 메소드(공백 포함)) : 사용자가 콘솔창에 값을 입력하고 엔터를 누를 때까지 대기. 엔터 누르면 입력한 모든 값을 가져온다. 이코드는 선언과 동시에 변수 초기화
									//next(); 문자열(공백 미포함)
		System.out.println("이름: " + name);
		
		//타입별로 받아올 수 있는 메소드가 존재
		System.out.println("나이 입력하세요: ");
		int age = sc.nextInt();
		System.out.println("나이: "+age);
		
		//문자는 문자열로 받아 String.charAt(index)이용하여 받는다.
		char gender = "M".charAt(0); //문자여러개 넣어도 charAt를 사용해 첫 글자 하나만 가져온다.
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int a = br.readLine();
	}
}
