package com.chap02_stringBuffer_stringBuilder.run;

public class Run {

	public static void main(String[] args) {
		//StringBuffer, stringBuilder
		//mutable클래스
		
		test1();
		test2();
		test3();
	}
	
	public static void test1() {
		//String str = new String("ab cde");
		StringBuilder sb = new StringBuilder("AB CDE");
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity()); //16 + 6
		
		StringBuffer sf = new StringBuffer("FG HI");
		System.out.println(sf);
		System.out.println(sf.length());
	}
	
	public static void test2() {
		String str = "Hello!";
		StringBuffer sf = new StringBuffer("Hi! ");
		StringBuilder sb = new StringBuilder("Hey~ ");
		
		//String 클래스
		System.out.println("str: "+str+", 주소: "+System.identityHashCode(str));
		str+=" I'm Java!";
		System.out.println("변경 후 str: "+ str+", 주소: "+System.identityHashCode(str));
		//주소값 변경된다.
		//str에 문자열을 추가한다면 기존에 str이 가르키는 값에 추가되는 것이 아니라 새로운 공간이 할당된다.
		
		//StringBuffer
		System.out.println("sf: "+sf+", 주소: "+System.identityHashCode(sf) );
		//sf += "I'm Java"; //불가능
		sf.append("I'm Java!");
		System.out.println("변경 후 sf: "+sf+", 주소: "+System.identityHashCode(sf) );
		//주소값 변경되지 않는다. 공간이 바뀌는 것이 아니다.
		//buffer build는 기존의 갖고있는 값의 공간을 늘리면서 새로운 값을 넣는다. 메모리 공간의 내부에서 늘리고 줄이는 과정이 진행된다.
		
		//StringBuilder
		System.out.println("sb: "+sb+", 주소: "+System.identityHashCode(sb));
		sb.append("I'm Java!");
		System.out.println("변경 후 sb: "+sb+", 주소: "+System.identityHashCode(sb));
		//주소값 변경되지 않는다.
	}
	
	public static void test3() {
		StringBuilder sb = new StringBuilder();
		//StringBuffer도 동일하게 작동된다. 차이점 : 쓰레드 세이프 지원 여부
		sb.append("오늘은 ");
		sb.append("금요일").append("입니다"); //메소드 체이닝 : 연쇄적으로 메소드 함수 나열
		System.out.println(sb);
		System.out.println(sb.length());
		sb.insert(4, "너무너무 신나는 ");
		System.out.println(sb);
		sb.delete(0,8);// 인덱스 0부터 7까지
		System.out.println(sb);
	}
}
