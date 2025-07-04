package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		//홍길동, 90, 70, 50
		//김길동, 80,50,20
		//최길동, 60
		//박길동
		//빈 4개를 생성하여 main에서 확인
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");
		
		Score hong = (Score)factory.getBean("hong");
		System.out.println(hong);
		
		Score kim = (Score)factory.getBean("kim");
		System.out.println(kim);
		
		Score choi =  (Score)factory.getBean("choi");
		System.out.println(choi);
		
		Score park = (Score)factory.getBean("park");
		System.out.println(park);
	}
}
