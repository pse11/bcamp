package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		
		Emp emp = factory.getBean("lee",Emp.class);
		Developer leecj = factory.getBean("leech", Developer.class);
		Engineer kimcj = factory.getBean("kimcj", Engineer.class);
		
		System.out.println(emp);
		System.out.println(leecj);
		System.out.println(kimcj);
	}
}
