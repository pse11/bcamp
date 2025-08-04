package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		//spring bean config 파일에서 작성된 Board클래스 bean을 3개 생성하여 main에서 확인
		// 객체의 필드 값들은 자유롭게 작성해 생성해봅시다.
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05/beans.xml");
		
		Member kim = factory.getBean("kim",Member.class);
		Member lee = factory.getBean("lee",Member.class);
		Member park = factory.getBean("park",Member.class);
		Board kboard = factory.getBean("kboard", Board.class);
		Board lboard = factory.getBean("lboard", Board.class);
		Board pboard = factory.getBean("pboard", Board.class);
		
		System.out.println(kim);
		System.out.println(lee);
		System.out.println(park);
		System.out.println(kboard);
		System.out.println(lboard);
		System.out.println(pboard);
		
		
	}

}
