package com.test03.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		//두 클래스(lgtv, samsungoledtv)의 빈을 생성하여
		//main에서 가져와 각각의 메소드 실행하며 확인
		//단, annotation을 활용하여 bean 생성!
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/anno/applicationContext.xml");
		
		TV lg = factory.getBean("lgTV",LgTV.class);
		lg.powerOn();
		lg.powerOff();
		TV samsung = factory.getBean("sam",SamsungOLEDTV.class);
		samsung.powerOn();
		samsung.powerOff();
		
		samsung = factory.getBean("samsung",SamsungOLEDTV.class);
		samsung.powerOn();
		samsung.powerOff();
	}

}
