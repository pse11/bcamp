package com.poly.part00_test.test07;

public class MTest {
	public static void main(String[] args) {
		//Object o = new Profile();
		//-> 호출 불가. 이유: 매개변수 생성자를 만들었을 때는 기본생성자 자동으로 만들어주지 않기때문에 기본생정자를 만들어줘야한다.
		
		MyProfile my = new MyProfile("박상은","010-1111-2222");
		my.jobLoc("서울시 강남구");
		my.display();
		
		
	}

}
