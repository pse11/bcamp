package com.test.part00_test.bbb;

import com.test.part00_test.aaa.AAA;

public class BBB extends AAA{//extends를 통해 AAA를 상속받는다.
	private int b;
	
	public BBB() {
		System.out.println("BBB 생성()");
	}
	public BBB(int b) {
		super(b);
		System.out.println("BBB 생성(b)");
		this.b=b;
	}
	
	public BBB(int no, int b) {
		
		super(no); //부모 생성자 초기화
		this.b = b;
		System.out.println("BBB 생성(no,b)");
	}
	
	//getter&setter
	public void setB(int b) {
		this.b=b;
	}
	public int getB() {
		return b;
	}
	
	public int getSum() {
		int sum = this.getB()+super.getNo(); //this: 여기의 getb, super: 부모의 getno 
		return sum;
	}
	
	//오버라이딩
	@Override
	public void prn() {
		System.out.println("BBB의 prn()");
	}
}
