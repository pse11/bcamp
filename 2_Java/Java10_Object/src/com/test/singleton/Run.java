package com.test.singleton;

public class Run {
	public static void main(String[] args) {
		//생성불가, 기본생성자 접근제한자가 private
		//Singleton s = new Singleton();
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1==s2); //참조형 변수 비교 : 같은 주소값을 가르키는 지 확인하는 것임
		//생성할 때 return new Singleton 으로 하면 false 나오는데 이유 : 생성할 때 new로 계속 생성하니까 매번 다른 공간이 할당되는 것이다
		//생성할 때 필드만들어서 return one하면 true 나옴
		System.out.println(s1);
		System.out.println(s2);
		
		s1.prn();
		s2.prn();
	}
}
