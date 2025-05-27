package com.collection.part01_list.arrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList {
	public void test() {
		
		//배열 선언
		int[] arr = new int[3];
		
		//ArrayList 선언
		ArrayList alist = new ArrayList();
		
		//다형성 적용
		List<Integer> list = new ArrayList<Integer>(); //Integer객체만 담겠다. -> 경고 노란 줄 사라짐
		Collection clist = new ArrayList();
		
		//ArrayList 는 저장 순서 유지, 중복 가능.
		//index로 접근 및 사용
		
		//추가
		//arrayList는 객체만 저장 가능
		alist.add("apple");// String 클래스 객체 넣었다.
		alist.add(123);  //Wrapper 클래스 사용 autoBoxing처리로 자동 객체화 된다. , int->autoBoxing ->Integer
		alist.add(45.67);
		alist.add(new Date());
		alist.add('A');
		//모든 타입을 다 저장할 수 있는것이 꼭 장점은 아님. 뭐가 들어간지 몰라서 사용할 때 문제가 생길 수도 있음. 그래서 노란줄 경고
		//하나의 큰 특징으로 볼 것.
		
		
		System.out.println("alist: " + alist.toString()); //alist: [apple], 해시값이 안나옴 => 오버라이딩 되어있군!
		
		//인덱스로 접근
		//배열의 크기 : length
		//리스트의 크기 : size()
		for(int i=0;i<alist.size();i++) {
			//값을 가져올때는 get(index)를 사용한다.
			System.out.println(i+" : "+alist.get(i));
		}
		
		
		//ArrayList는 중복 저장 허용
		alist.add("apple");
		System.out.println("alist: "+alist);
		
		alist.add(new String("apple")); //주소값이 다르기때문에 완전히 다른 값이다.
		System.out.println("alist: "+alist);
		
		//리스트 중간 특정 인덱스 위치에 값 추가. 하나씩 뒤로 밀리는 것 확인 가능하다.
		alist.add(1,"banana");
		System.out.println("alist: "+alist);
		
		//==========================================
		//삭제
		alist.remove(2);
		System.out.println("alist: "+alist);
		System.out.println(alist.get(2));
		
		//수정
		alist.set(1, true);
		System.out.println("alist: "+alist);
		
		System.out.println(alist.size()+"개");
		System.out.println(alist.isEmpty());
		alist.clear();
		System.out.println(alist.size()+"개");
		System.out.println(alist.isEmpty()); //밑에꺼보다 isEmpty()훨씬 간단하게 사용가능
		System.out.println(alist.size()==0);
		
	}
	
	//정렬
	public void testSort() {
		//기본적으로 제공되는 sort()메소드, 오름차순 정렬된다.
		ArrayList list = new ArrayList();
		list.add("apple");
		list.add("orange");
		list.add("mango");
		list.add("banana");
		list.add("grape");
		
		System.out.println("list: "+list);
		
		//오름차순
		//list.sort(null); //null 자리 : 정렬 기준, null은 기본값(오름차순)
		Collections.sort(list);
		System.out.println("list: "+list);  //리스트 자체가 바뀐것이다.
		
		//재미삼아
		Iterator dIter = new LinkedList(list).descendingIterator();
		
		ArrayList descList = new ArrayList();
		
		while(dIter.hasNext()) {
			descList.add(dIter.hashCode());
		}
		
		//내림차순
		
		
	}
	
}



























