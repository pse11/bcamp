package com.test.part03_test;

import com.test.part02_OverridingTest.book.Book;

public class Run {
	public static void main(String[] args) {
		Car c1 = new Suv("하얀");
		c1.accelPedal();
		
		System.out.println(c1.toString());
		
//		Object obj = new Suv();//object로 선언하면 다 받을 수 있다. 단, 이렇게 담으면 어떤 객체가 있는지 정확하게 파악하지 못하게되면 문제가 발생
//		Book b = (Book)obj;
		
		//c1.bPedal(); //현대 담겨있는건 car클래스이다 보니 sub에만 선언된건 사용할 수 없다.
		
		
	}
	
}
