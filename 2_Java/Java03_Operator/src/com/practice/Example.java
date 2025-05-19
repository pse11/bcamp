package com.practice;
import java.util.Scanner;
public class Example {
	Scanner sc = new Scanner(System.in);
	public void sample1() {
		
		System.out.print("국어:");
		int gook = sc.nextInt();
		System.out.print("영어:");
		int eng = sc.nextInt();
		System.out.print("수학:");
		int math = sc.nextInt();
		int sum;
		double avg;
		sum=gook+eng+math;
		avg = sum/3.0;
		System.out.printf("sum:%d, avg:%f",sum,avg);
		System.out.println();
		String res = (gook>=40&&eng>=40&&math>=40&&avg>=60)?"합격":"불합격";
		System.out.println(res);
	}
	public void sample2() {
		System.out.print("학생이름: ");
		String name = sc.nextLine();
		System.out.print("학년: ");
		int grade = sc.nextInt();
		System.out.print("반: ");
		int ban = sc.nextInt();
		System.out.print("번호: ");
		int num = sc.nextInt();
		System.out.print("성별(M/F): ");
		char fm = sc.next().charAt(0);
		System.out.print("성적: ");
		float score = sc.nextFloat();
		String fms = (fm=='M')?"남":"여";
		System.out.printf("%d학년 %d반 %d번 %s학생 %s은 성적이 %.2f이다.",grade,ban,num,fms,name,score);	
	}
	public void sample3() {
		System.out.print("정수: ");
		int num = sc.nextInt();
		System.out.println((num>0)?"양수다":"양수가 아니다");
	}
	public void sample4() {
		System.out.print("정수: ");
		int num = sc.nextInt();
		String result = (num%2==0)?"짝수다":"홀수다";
		System.out.println(result);
	
	}
}
