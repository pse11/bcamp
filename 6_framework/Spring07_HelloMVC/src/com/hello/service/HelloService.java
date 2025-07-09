package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.dao.HelloDao;

@Service
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
