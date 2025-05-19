package com.test01;

import java.util.Scanner;

public class IfTest02 {
	//else if : 다중 조건을 줄 수 있는 문법
	public void testElseIf1() {
		int i=10, j=20;
		if(i>j) {
			System.out.println("i가 j보다 크다");
		}else if(i==j) {
			System.out.println("i와 j는 같다");
		}else {
			System.out.println("i가 j보다 작다");
		}
	}
	public void testElseIf2() {
		//점수 하나를 입력 받아서 등급을 나누어 점수와 등급을 출력
		//90이상 A
		//90미만 80이상 B
		//80미만 70이상 C
		//70미만 60이상 D
		//60미만 F
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수: ");
		int score = sc.nextInt();
		char grade = ' '; //문자는 빈 문자로 초기화할 수 없다.(공백으로 초기화 해주자)
		
		if(score>=90) {
			grade='A';
		}else if(score>=80) {
			grade='B';
		}else if(score>=70) {
			grade='C';
		}else if(score>=60) {
			grade='D';
		}else {
			grade='F';
		}
		System.out.println("grade: "+grade);
	}
	public void testElseIf3() {
		//testElseIf2에서
		//각 등급별 중간 점수 이상의 경우에는 
		//등급에 + 라는 문자를 추가하여 출력.
		//95이상은 A+
		//85이상은 B+
		Scanner sc = new Scanner(System.in);
		System.out.print("점수:");
		int score = sc.nextInt();
		String grade = "";
		if(score>=90) {
			grade="A";
			if(score>=95) {
				grade += "+";
			}
		}else if(score>=80) {
			grade = "B";
			if(score>=85) {
				grade += "+";
			}
		}else if(score>=70) {
			grade = "C";
			if(score>=75) {
				grade+="+";
			}
		}else if(score>=60) {
			grade = "D";
			if(score>=65) {
				grade+="+";
			}
		}else {
			grade = "F";
		}
		
		/*
		 if(score%10>=5){
		 	grade+="+"; 이렇게 해주면 한번에 + 처리를 할 수도 있다.
		 */
		System.out.println("grade: "+grade);
	}
}
