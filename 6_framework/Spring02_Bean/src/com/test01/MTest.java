package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
		
		MessageBean fruit = (MessageBean)factory.getBean("fruit");//인터페이스 객체 선언 이유: 확장성 => applicationContext.xml에서 구현체만 바꾸면, 자바 코드를 안 바꿔도 됨.
		fruit.sayHello();
		
		MessageBean apple = (MessageBean)factory.getBean("apple");
		apple.sayHello();
		
		//id가 mango인 bean을 가지고 와서 sayHello() 출력.
		//단, mango bean은 매개변수3개인 생성자 이용하여 bean생성!(매개변수 값은 마음대로)
		MessageBean mango = (MessageBean)factory.getBean("mango");
		mango.sayHello();
	}
}
