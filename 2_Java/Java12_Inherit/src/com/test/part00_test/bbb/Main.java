package com.test.part00_test.bbb;

import com.test.part00_test.aaa.AAA;

public class Main {

	public static void main(String[] args) {
		AAA a1 = new AAA();
		a1.setNo(10);
		System.out.println("no: "+a1.getNo());
		a1.prn();
		
		BBB b1 = new BBB(1);
		System.out.println("b: "+b1.getB());
		b1.prn(); //상속받았기 때문에 사용가능하다.
		
		/////////////
		System.out.println("=====================");
		BBB bbb1 = new BBB(); ///BBB클래스로 객체 만들어준다.
		bbb1.setB(1);
		bbb1.setNo(2);
		System.out.println(bbb1.getNo() +" + "+bbb1.getB()+"="+bbb1.getSum());
		
		BBB bbb2 = new BBB(2);
		bbb2.setB(4);
		System.out.println(bbb2.getNo() +" + "+bbb2.getB()+"="+bbb2.getSum());
		
		BBB bbb3 = new BBB(10,5);
		System.out.println(bbb3.getNo() +" + "+bbb3.getB()+"="+bbb3.getSum());
		
		bbb3.prn();
		
	}

}
