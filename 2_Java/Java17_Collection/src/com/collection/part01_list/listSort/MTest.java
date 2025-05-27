package com.collection.part01_list.listSort;

public class MTest {

	public static void main(String[] args) {
		new Controller().test();
		
		System.out.println("박상은".compareTo("홍길동")); //음수 리턴
		//홍길동이 오름차순에서 더 오른쪽에 위치, 음수리턴하면 자리 바꿀 필요가 없다.
		System.out.println("홍상은".compareTo("홍길동")); //양수 리턴
		
		System.out.println("홍길동".compareTo("홍길동")); //0 리턴
	}
	
}