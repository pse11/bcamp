package com.test03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MTest{

	public static void main(String[] args) {
		MyCalc sum = (a,b)->a+b;
		MyCalc sub = (a,b)->a-b;
		MyCalc mul = (a,b)->a*b;
		MyCalc div = (a,b) ->a/b;
		
		System.out.println(sum.calc(10, 3));
		System.out.println(sub.calc(10,3));
		
		//
		List<String> list = new ArrayList<>();
		
		Collections.sort(list, new Comparator<String>() { //compartoar를 만들어서 조건부에 대입해 그 기준으로 정렬
			@Override
			public int compare(String o1, String o2) {
				return 0;
			}
		});
		
		//->위에 걸 람다식으로 작성
		//comparator: 인터페이스 -> 이 안에 compare 메소드 사용
		Collections.sort(list, (o1,o2)->o1.compareTo(o2));
	}

}
