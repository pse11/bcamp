package com.test05.pointcut_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/pointcut_method/applicationContext.xml");
		
		Person s = factory.getBean("student",Person.class);
		Person t = factory.getBean("teacher" ,Person.class);
		
		s.classWork();
		System.out.println("---------------");
		t.classWork();
	}

}
