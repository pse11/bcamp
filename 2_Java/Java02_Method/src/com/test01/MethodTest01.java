package com.test01;

public class MethodTest01 {
	public static void main(String[] args) {
		//static 메소드 실행
		//클래스명.메소드명();   //원칙상 클래스명까지 적어줘야함. 
		MethodTest01.publicMethod();
		MethodTest01.protectedMethod();
		MethodTest01.defaultMethod();
		privateMethod();
		
		//nonStaticMethod 실행
		//클래스명 변수명 = new 클래스명();
		//변수명.메소드명();
		MethodTest01 mt = new MethodTest01();
		mt.NonstaticMethod();
		
	}
	
	//접근제한자
	
	//public : 어디서나 누구나 접근,참조 가능하다 (+)	+test1();
	public static void publicMethod() {
		System.out.println("public method");
	}
	
	//protected : 상속일 경우 상속된 곳에서
	//상속이 아닐 경우 같은 패키지 안에서 접근,참조 가능하다. (#)
	protected static void protectedMethod() {
		System.out.println("protected method");
	}
	
	//같은 패키지 안에서 접근, 참조 가능하다. (default)
	static void defaultMethod() {
		System.out.println("defaultMethod");
	}
	
	//현재 클래스 안에서만 접근, 참조 가능하다. (-)
	private static void privateMethod() {
		System.out.println("private method");
	}
	
	public void NonstaticMethod() {
		System.out.println("nonStatic method"); // static 키워드 붙으면 static영역에서 프로그램 실행하자마자 준비
		// 안붙으면 실행방법 달라짐
	}
}
