package com.test01.notAOP;

public class Student {
	public void classWork() {
		System.out.println("컴퓨터를 켠다."); //student, teacher 공통 부분
		
		try {
			System.out.println("qr을 찍는다."); //핵심기능
		}catch(Exception e) {
			System.out.println("쉬는 날이었다.");  //student, teacher 공통 부분
		}finally {
			System.out.println("집에 간다.");  //student, teacher 공통 부분
		}
	}
}
