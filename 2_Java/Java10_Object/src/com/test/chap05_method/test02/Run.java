package com.test.chap05_method.test02;

import java.util.Scanner;

public class Run {
	//ctrl + space : 자동완성
	public static void main(String[] args) {
		MethodTest mt = new MethodTest();
		
		//각종의 메소드 호출(실행)
		//1. 매개변수X, 반환값X 메소드 실행
		mt.method1();
		
		//2.매개변수X, 반환값O 메소드 실행
		String str = mt.method2();
		System.out.println(str);
		
		//3. 매개변수O, 반환값X
		mt.method3(10, 20);
		
		//4. 매개변수O, 반환값O
		System.out.println("res: "+mt.method4(20,40));
		
		//static 메소드 실행
		//클래스명.메소드명();
		StaticMethodTest.staticMethod1();
		System.out.println("res : "+StaticMethodTest.staticMethod2());
		StaticMethodTest.staticMethod3("박상은");
		System.out.println(StaticMethodTest.staticMethod4("임현성"));
		
	}
}
