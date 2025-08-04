package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		
		//BeanFactory(지금은 거의 사용x)
//		Resource res = new ClassPathResource("com/test03/beans.xml");
//		BeanFactory factory = new XmlBeanFactory(res);
		//getBean을 하는 순간 객체 생성
		//처음 bean호출하는 시점에 객체 생성
		//lazyloading이라고 하기도 함
//		ko 생성!
//		안녕하세요, 스프링
//		en 생성!
//		Hello, spring
		
		//ApplicationContext
		//beanfactory를 확장한 ioc 컨테이너. bean을 등록하고 관리
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		//applicationcontext를 초기화할때 객체(bean)미리 생성
//		ko 생성!
//		en 생성!
//		안녕하세요, 스프링
//		Hello, spring
		
		MessageBean bean = (MessageBean)factory.getBean("korean"); //beanfactory에서 bean을 가지고 오겠다.
		bean.sayHello("스프링");
		
		bean = (MessageBean)factory.getBean("english"); //실제로 객체를 내가 아닌 spring이 만든다.
		bean.sayHello("spring");
	}

}
