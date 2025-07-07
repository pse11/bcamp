package com.test04.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		//Engineer, Developer클래스 bean을 생성하여
		//main에서 확인
		//해당 클래스들의 필드는 초기화되어있어야 하며
		//toString을 통해 필드값 확인
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/anno/applicationContext.xml");
		
		Engineer en = factory.getBean("engineer",Engineer.class);
		System.out.println(en);
		Developer de = factory.getBean("developer",Developer.class);
		System.out.println(de);
		
		Emp emp1 = factory.getBean("emp1",Emp.class);
		System.out.println(emp1);
		
		Developer lee = factory.getBean("developer",Developer.class);
		System.out.println(lee);
	}

}
