package com.test01;

public class Operator02 {
	public static void main(String[] args) {
		Operator02 o = new Operator02();
		o.test1();
		o.test2();
		o.test3();
	}
	//++ : 1증가, ++값, 값++
	//-- : 1감소, --값, 값--
	public void test1() {
		int no = 20;
		
		System.out.println("현재 no: " + no);
		
		++no;
		System.out.println("++no의 결과: " + no);
		
		no++;
		System.out.println("++no의 결과: " + no);
		
		--no;
		System.out.println("--no의 결과: " + no);
		
		System.out.println("-------------------");
		
		int num1 = 20;
		
		//후위연산자 : 다른 계산 먼저 처리 한 후 증감처리된다.
		int res = num1++ * 3;
		System.out.println("res: " + res);
		System.out.println("num1: " + num1);
		
		//전위연산자 : 증감을 먼저 처리 한 후 다른 계산을 한다.
		num1 = 20;
		res = ++num1 * 3;
		System.out.println("res: " + res);
		System.out.println("num1: " + num1);
		
		//2씩 증가 하고 싶다.(복합 대입 연산자)
		//+= 2 
		
	}
	public void test2() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println(num1+num2);
		System.out.println(num1-num2);
		System.out.println(num1*num2);
		System.out.println(num1/num2);
		System.out.println(num1%num2);
		
		//%
		//홀수나 짝수냐, 배수 구할 때 많이 씀
	}
	public void test3() {
		//비교연산 : 비교 후 논리값을 결과값으로 받는다.
		//<,>,<=,>=,==,!=
		int a=10,b=20;
		boolean res1, res2, res3;
		
		res1 = a == b;
		res2 = (a != b);
		res3 = (a<=b);
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
		
	}
	
}
