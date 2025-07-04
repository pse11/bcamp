package com.test04.setter_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/setter_di/applicationContext.xml");
		
		Address park = (Address)factory.getBean("park");
		System.out.println(park);
		
		Address kim = (Address)factory.getBean("kim");
		System.out.println(kim);
		
		Member mpark = (Member)factory.getBean("mpark");
		Member mkim = (Member)factory.getBean("mkim");
		Member mlee = (Member)factory.getBean("mlee");
		System.out.println(mpark);
		System.out.println(mkim);
		System.out.println(mlee);
	}

}
