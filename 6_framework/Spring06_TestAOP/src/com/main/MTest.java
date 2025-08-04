package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Shape;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/main/applicationContext.xml");
		
		Shape rect = factory.getBean("rect", Shape.class);
		Shape tri = factory.getBean("tri", Shape.class);
		
		rect.viewSize();
		System.out.println("----");
		tri.viewSize();
		
	}
}
