package com.chap01_string.run;

public class Run {

	public static void main(String[] args) {
		//String 클래스
		//문자열, immutable(불변)
		
		test1();
		test2();
	}
	
	public static void test1() {
		
		//문자열 리터럴로 생성
		String str = "abc";
		String str1 = "abc";
		//String pool 활용
		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		
		System.out.println("-----------------");
		//문자열 객체로 생성 new 연산자로 사용
		String str2 = new String("abc"); //새로운 공간 할당해서 값 집어넣고 주소값 리턴
		String str3 = new String("abc");
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		//hashCode가 모두 같다.
		System.out.println("abc".hashCode());
		//이유: 오버라이딩 되어있기 때문에 같은 값일 경우 같은 hascode를 갖는다. 
		
		System.out.println("---------------------");
		System.out.println("str: "+System.identityHashCode(str));
		System.out.println("str1: "+System.identityHashCode(str1));
		System.out.println("str2: "+System.identityHashCode(str2));
		System.out.println("str3: "+System.identityHashCode(str3));
		//안에 들어있는 값이 같은지 상관안하는 고유의 해시코드 값
		
		System.out.println(str == str1); //true   안의 문자열이 아닌
		System.out.println(str2 == str3);//false  공간이 같은지 비교하는 것.
		
		String s1 = new String("ABC");
		String s2 = new String("ABC"+"D");
		String s3 = "ABCD";
		System.out.println("------------");
		System.out.println(s1 == s2); //리터럴로 생성할 때와 new 연산자로 객체 생성하는 것은 다르다.
		System.out.println(s1 == s3);
		System.out.println(s2 == s3); //s3는 string pool로 처리된 것 
		System.out.println(s2.intern() == s3); //String.intern() : == 연산자 사용할 때 안의 문자열이 같은지 비교해주는 메소드
	}
	
	public static void test2() {
		//String클래스의 대표 메소드
		String str = "abc";
		System.out.println(str.charAt(1));
		System.out.println(str.concat("def"));  //연결, 원본엔 영향 없는듯하다.
		System.out.println(str.contains("ab"));  //포함여부 true/false
		System.out.println(str.equals("abc"));
		System.out.println(str.length());
		
		str = "a,b,c";
		String[] arr = str.split(",");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		str = "      ab c   ";
		System.out.println(str);
		//앞뒤공백제거(trim)
		System.out.println(str.trim());
		
	}
}
