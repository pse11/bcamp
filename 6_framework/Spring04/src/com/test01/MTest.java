package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		//적절한 값을 저장하며 TV클래스 빈을 하나 생성하여
		//main에서 확인
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		TV tv = factory.getBean("tv",TV.class);
		System.out.println(tv);
		
		Phone phone = factory.getBean("phone", Phone.class);
		System.out.println(phone);
	}
}
