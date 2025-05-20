package com.test.chap03_field.test01;

public class KindsOfVariable2 {
	public static int staticNum;
	
	public final int finalNum =1; //전역변수로 final 쓸 경우 초기화해줘야함(힙 영역에 생성되니)
	
	
	//public 접근 제한자에 static, final 키워드 함께 사용하는 필드 = '상수필드'
	public static final int STATIC_NUM = 1; //상수 선언으로 변경 불가능.  
	public final static int STATIC_NUM2 = 2; //static, final 순서는 상관없다.
	
	public void methodTest() {
		//static int localStaticNum; //메소드 안에서는 static선언 안됨
		final int localFinalNum;   //메소드 안에서는 final선언 가능
		
	}
	public static void methodTest2() {
		//static int localStaticNum; static 만들어지는 시점이 꼬이기 때문에 만들지 말것ㅅ
		//	static이 필요할 경우 필드로서 만들자
		final int localFinalNum;
	}
}
