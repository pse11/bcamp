package com.test.singleton;

public class Singleton {
	//클래스의 객체를 하나만 생성해서 사용하는 패턴
	
	private static Singleton one; //필드 선언, (타입 : singleton)
	
	//생성자 만들기
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		//return new Singleton(); //같은 클래스 내이기 때문에 기본생성자 생성 가능
		//해당 메소드가 호출이 될때 Singleton객체를 생성해서
		//one에 저장
		//단, 첫 호출시에만.
		if(one==null) {
			one = new Singleton();
		}
		return one;
	}
	
	public void prn() { //singleton객체가 있으면 일반 메소드 사용 가능
		System.out.println("Singleton클래스의 일반 메소드");
		System.out.println(this);
	}
	
	//단점: 결합도가 높아져서 하나가 잘못되면 이곳저곳의 문제가 많아질 수 있다.
	
}
