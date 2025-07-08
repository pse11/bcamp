package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Person s = factory.getBean("student",Person.class);
		Person t = factory.getBean("teacher", Person.class);
		
		System.out.println("[학생]");
		s.classWork();
		System.out.println("----------");
		System.out.println("[강사]");
		t.classWork();
	
		System.out.println("----------");
//		AOP 적용X
//		Test test = new Test();
//		test.classWork();
		
		Person test = factory.getBean("test",Person.class);
		test.classWork();
		((Test)test).test(); //proxy 가상의 객체 생성했기때문에 자바에서처럼 다형성으로 메소드 접근 불가능, test() 실행하고 싶으면 상속을 받지 말것 
//		Test test = factory.getBean("test",Test.class);
//		test.classWork();
//		test.test();
		//인터페이스 상속받은 경우 jdk프록시가 돌아감. 그 외는 다른 프록시가 돌아감
	}

}
