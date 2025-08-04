package com.hello.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	
	public String getHello() {
		return "SpringMVC";
	}
	
	public String getBye() {
		return "SpringMVC";
	}
}
