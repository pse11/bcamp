package com.test04.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean("emp1")
	public Emp emp1() {
		return new Emp("홍길동",30);
	}
	
	@Bean("emp2")
	public Emp emp2() {
		return new Emp("김길동",40);
	}
}
