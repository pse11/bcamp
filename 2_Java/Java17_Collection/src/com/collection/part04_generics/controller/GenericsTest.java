package com.collection.part04_generics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericsTest {
	public void test() {
		//제너릭이란
		//다루려는 클래스 타입을 지정
		//컬렉션에서 다룰 클래스 타입을 제한하여 한가지 종류의
		//클래스타입 객체만 저장하게하는 기능
		
		//잘못된 타입을 사용하여 형변환 등의 작업을 할 가능성을 제거
		//컬렌션에 다양한 종류의 객체가 저장되어있다 꺼내 사용할때마다 형변환 해야햔다. 그로인해 코드가 복잡해진다.
		
		//<> 해당 기호를 이용하여 클래스 명시
		
		List list = new ArrayList();
		
		//객체 저장
		list.add(new String("String Object"));	
		list.add(new Book());
		list.add(new Student());
		list.add(new Car());
		
		System.out.println("저장된 객체 수: "+list.size());
		System.out.println("list: "+list);
		
		//저장된 객체를 꺼내 사용할때
		for(int i=0;i<list.size();i++) {
			Object obj = list.get(i);
			
			if(obj instanceof String) {
				System.out.println(((String)obj).equals("test"));
			}else if(obj instanceof Book) {
				((Book) obj).prnBook();
			}else if(obj instanceof Student) {
				((Student)obj).score();
			}else if(obj instanceof Car) {
				((Car)obj).printCar();
			}
			
		}
	}
	public void test2() {
		//제네릭스 : 컬렉션에 저장되는 객체의 자료형 제한
		List<Book> list = new ArrayList<Book>();
		//해당 list에는 Book클래스 객체만 저장하겠다
		
		//list.add("test"); //Book클래스 객체가 아닌 String 객체
		list.add(new Book());
		list.add(new Book());
		
		for(int i=0;i<list.size();i++) {
			list.get(i).prnBook();
		}
		//////
		List list2 = new ArrayList();
		list2.add(new Book());
		list2.add(new Book());
		for(int i=0;i<list2.size();i++) {
			//list2.get(i).prnBook(); //object객체니까 prnBook사용 불가능
			((Book)list2.get(i)).prnBook();
 		}
	}
	public void test3() {
		//Map에 제네릭스 적용
		HashMap<String,Book> map = new HashMap<>();
		//map.put("one","test"); //에러, value에 String 안됨
		map.put("one",new Book("java"));
		map.put("two",new Book("JS"));
		map.put("three",new Book("HTML"));
		
		System.out.println(map);
		
		System.out.println("=================");
		Set<Map.Entry<String,Book>>entry = map.entrySet(); //Set안에는 엔드리객체가 들어오기 때문에 <Map.Eentry>설정
		Iterator<Map.Entry<String, Book>> it = entry.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Book> en = it.next();
			String key = en.getKey();
			Book val = en.getValue();
			System.out.println(key+":"+val);
		}
		
		//keySet()을 이용하여 value확인
		//제네릭스 사용
		Set<String> keys = map.keySet(); //key들만 set으로 받아온다.
		Iterator<String> keyIt = keys.iterator();
		while(keyIt.hasNext()) {
			String key = keyIt.next();
			Book b = map.get(key);
			System.out.println(key+"="+b);
		}
	}
}

//한 클래스파일(.java)안에 여러 클래스 정의 가능
//단, public 접근제한자 1개만 가능 나머지는 default
class Book{
	private String title;
	public Book() {}
	public Book(String title) {
		this.title=title;
	}
	public void prnBook() {
		System.out.println("printBook() call...");
	}
	@Override
	public String toString() {
		return "book "+title;
	}
	
}
class Student{
	public Student() {}
	
	public void score() {
		System.out.println("score() call...");
	}
	@Override
	public String toString() {
		return "student";
	}
}
class Car{
	public void printCar() {
		System.out.println("printCar() call...");
	}
	@Override
	public String toString() {
		return "car";
	}
}
