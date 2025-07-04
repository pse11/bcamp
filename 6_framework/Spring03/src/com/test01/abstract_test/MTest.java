package com.test01.abstract_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/abstract_test/applicationContext.xml");
		//xml을 읽고 AbstractTest obj = AbstractTest.getInstance(); 이걸 스프링이 실행한다.
		/*
		 * new ClassPathXmlApplicationContext실행하면
		 * 스프링은 .xml 파일을 읽어서
		 * 그안에 정의된 <bean>들을 전부 파싱해서 
		 * 각 <bean>에 따라 객체를 생성하고
		 * 생성자, setter등을 통해 의존성 주입.
		 */
		
		
		//abstract는 객체 생성 불가능하기때문에 에러 발생
		AbstractTest today = (AbstractTest)factory.getBean("test");
		//getBean: 이미 생성된 빈을 가져옴
		System.out.println("오늘은 "+today.dayInfo());
	}

}
