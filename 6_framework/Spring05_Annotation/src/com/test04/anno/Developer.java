package com.test04.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Developer {

	private Emp emp;
	private String dept;
	
	public Developer() {}
	
	//emp를 찾아서 넣어주는데 emp가 많기때문에 qualifier로 emp 지정
	@Autowired
	public Developer(@Qualifier("emp2")Emp emp, @Value("개발팀")String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}
	@Override
	public String toString() {
		return emp + "\t 부서: " + dept;
	}
	
}	
