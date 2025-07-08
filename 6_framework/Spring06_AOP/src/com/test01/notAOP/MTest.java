package com.test01.notAOP;

public class MTest {

	public static void main(String[] args) {
		Student s = new Student();
		Teacher t = new Teacher(); //객체 만들기
		
		System.out.println("[학생]");
		s.classWork();
		System.out.println("----");
		System.out.println("[강사]");
		t.classWord();
		
	}

}
