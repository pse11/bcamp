package com.test.chap01_encapsulation;

public class Main {

	public static void main(String[] args) {
		//객체 생성
		Account a = new Account(); //주소값이 a 객체에 들어간다.

		//잔액조회
		a.prnBalance();
		
		//입금
		a.in(50000);
		a.prnBalance();
		
		a.in(2000);
		a.prnBalance();
		
		//출금
		a.out(30000);
		a.prnBalance();
		
		//a.balance -=200000; //필드에 직접적인 접근할 수 있다. 단 클래스에서 private 선언하면 접근할 수 없다.
	
		
		a.out(30000);
		a.prnBalance();
		
		//객체 추가
		//Account a = new Account();중복 안됨
		
	}

}
