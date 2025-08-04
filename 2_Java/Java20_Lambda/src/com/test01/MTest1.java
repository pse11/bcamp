package com.test01;

public class MTest1 {
	
	public static void main(String[] args) {
		//gui로 쓸때 이벤트처리 이런식으로 많이 함
		//자바 어플리케이션 만들때 버튼 클릭하거나 하는 이벤트처리 할때 많이 사용
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hi");
			}
		};
		
		//람다식
		Runnable r2 = ()->System.out.println("Hello");
		
		r.run();
		r2.run();
		
		//////////////////////////////
		
		Test01 test01_0 = new Test01() {
			@Override
			public void prn() {
				System.out.println("test01_0");
			}
		};
		test01_0.prn();
		
		//()->{code;}
		Test01 test01_1 = () -> {System.out.println("test01");};
		test01_1.prn();
		
		//(param) -> {code;}
		Test02 test02_1 = (int n)->System.out.println("input no: "+n); //실행 코드 한줄: {} 생략 가능
		test02_1.prn(20);
		//매개변수 타입은 대부분 짐작 가능하여 생략하는 경우가 많다.
		Test02 test02_2 = (n) ->System.out.println("input no: "+n);
		test02_2.prn(22);
		Test02 test02_3 = n->System.out.println("input no: "+n);
		test02_3.prn(23);
		
		//(param) ->{code;return;}
		Test03 test03 = n->n+n;//return 코드 한줄이라 return 생략
		System.out.println(test03.prn(3));
		test03 = n->{
			System.out.println(n+"입력");
			return n+n;
		};
		System.out.println(test03.prn(5));
		
		//(param,param) ->{code;return;}
		Test04 test04 = (n,m)->{
			System.out.println("n:"+n+",m: "+m);
			return n*m;
		};
		System.out.println(test04.prn(5, 4));
	}

}
