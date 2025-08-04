package com.test02.date_number;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {
	private MyClass myClass;
	
	public BeanTest() {
		System.out.println("기본 생성자()");
	}
	
	public BeanTest(Date date) {
		System.out.println("날짜 생성자(date: "+date+")");
	}
	
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("setMyClass() 호출: "+myClass);
	}
	
	public void setDate(Date date) {
		System.out.println("setDate() 호출: "+date);
	}
	public void setNumber(int num) { //bean 생성시 매개변수 num의 타입에 맞는 값을 전달해줘야한다.
		System.out.println("setNumber() 호출: "+num);
	}
	public void setArray(String[] arr) {
		System.out.println("setArray() 호출");
		for(String val : arr) {
			System.out.println(val);
		}
	}
	public void setList(List<String> list) {
		System.out.println("setList() 호출");
		for(String val : list) {
			System.out.println(val);
		}
	}
	public void setSet(Set<String> set) {
		System.out.println("setSet() 호출: "+set);
	}
	public void setMap(Map<String,String> map) {
		System.out.println("setMap() 호출: "+map);
	}
	public void setScore(List<Score> list) {
		System.out.println("setScore() 호출");
		for(Score sc: list) {
			System.out.println(sc);
		}
	}
}
