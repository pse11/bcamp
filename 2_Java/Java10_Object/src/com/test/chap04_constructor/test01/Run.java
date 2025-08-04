package com.test.chap04_constructor.test01;

import java.util.Date;

public class Run {

	public static void main(String[] args) {
		User u1 = new User(); //기본 생성자로 객체를 만든다.
		u1.info();
		
		User u2 = new User("admin","1234","박상은");
		u2.info();
		
		User u3 = new User("user01","1234","최상은",new Date());
		u3.info();
		
		u1.setUserId("usr02");
		u1.setUserPwd("3235");
		u1.setUserName("김상은");
		u1.info();
		System.out.println(u1.getUserId());
	}

}
