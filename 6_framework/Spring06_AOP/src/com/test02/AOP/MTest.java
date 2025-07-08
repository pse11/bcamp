package com.test02.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		//spring aop 아닐때
//		Person s = new Student();
//		s.classWork(); //이게 호출될때 myspect가 가로챈다.
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/AOP/applicationContext.xml");
		
		Person s = factory.getBean("student",Person.class);
		Person t = factory.getBean("teacher",Person.class);
		
		System.out.println("[학생]");
		s.classWork();
		System.out.println("-------------");
		System.out.println("[강사]");
		t.classWork();
	}

}
