package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.dao.HelloDao;

@Service //자바는 클래스가 타입이기 때문에 HelloService타입의 빈이 service로 생성
public class HelloService {
	
	//private HelloDao dao = new HelloDao();
	@Autowired
	private HelloDao dao;
	
	public String getHello() {
		String str = dao.getHello();
		return "Hello, "+str;
	}
	
	public String getBye() {
		String str = dao.getBye();
		return "Bye, "+str;
	}
}
