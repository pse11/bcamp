package com.collection.part01_list.listSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
	public void test() {
		//다형성 적용
		List list = new ArrayList();
		list.add(new Score("홍길동",99)); //Score객체 넣어준다.
		list.add(new Score("김상은",50));
		list.add(new Score("이상은",80));
		
		list.add(new Score("정상은",66));
		list.add(new Score("최상은",33));
		list.add(new Score("양상은",22));
		
		System.out.println("list: "+list);
		
		//list.sort(null); //에러!
		//Collections.sort(list); //에러!
		
		//1. Comparable - 기본이 되는 정렬 기준 구현
		//해당 클래스(객체 생성하는 클래스,Score)에 구현
		//Score 객체 정렬해!
		//2. Comparator - 기본 정렬 기준 이외 다른 정렬 기준 구현
		//새로운 클래스에 구현
		//Score 객체 나이 오름차순 정렬해!
		
		//list안의 객체 정렬
		list.sort(null);
		System.out.println("list: "+list);
		
		list.sort(new PointAsc());
		System.out.println("list: " +list);
		
		//이름 내림차순, 점수 내림차순 정렬을 할 수 있게
		//클래스 생성하고 그 기준에 맞게 완성해보자.
		//NameDesc.java, PointDesc.java
		list.sort(new NameDesc());
		
		/////
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list,new PointDesc());
		System.out.println(list);
			
		
	}
	
}
