package com.test.chap01_encapsulation;

public class Account {
	//추상화 : 필드, 메소드를 채워넣는 것
	//필드 : 변수 만든다 //객체를 만들면 변수 5개가 묶여있는 공간이 생성된다.
	private String name = "박상은";
	private String accNo = "010-1111-2222"; //계좌번호
	private String pwd = "1234";
	private int bankCode = 22;
	private int balance = 0; //잔액
	
	//메소드
	
	//생성자(객체 생성을 위한 일종의 메소드) void를 작성하지 않는다. 생략 가능
	public Account() {}
	
	//입금
	public void in(int money) {
		if(money > 0) {
			balance += money;
			System.out.println(name + "님의 계좌에 "+money+"원이 입금되었습니다.");
		}else {
			System.out.println("잘못된 금액을 입력하였습니다.");
		}
		
	} //void : 리턴 타입
	//출금
	public void out(int money) {
		if(money<balance) {
			balance -= money;
			System.out.println(name +"님의 계좌에서 "+money+"원이 출금되었습니다.");
		}else {
			System.out.println("잔액이 부족합니다. 잔액을 확인하세요");
		}
	}
	
	//잔액 확인
	public void prnBalance() {
		System.out.println(name+"님의 계좌에 잔액은 "+balance+"원 입니다.");
	}
	
}
