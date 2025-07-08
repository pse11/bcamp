package com.test04.AOP_anno;

public class Teacher implements Person{

	@Override
	public String classWork() {
		String s = null;
		s.length();
		
		System.out.println("줌 회의를 시작한다.");
		return "Spring";
	}

}
