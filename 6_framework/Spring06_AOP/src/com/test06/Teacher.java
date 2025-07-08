package com.test06;

import org.springframework.stereotype.Component;

@Component
public class Teacher implements Person{

	@Override
	public String classWork() {
		System.out.println("줌 회의를 시작한다.");
		return "string";
	}

}
