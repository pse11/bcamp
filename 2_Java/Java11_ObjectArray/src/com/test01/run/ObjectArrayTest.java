package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectArrayTest {
	public static void main(String[] args) {
		int[] arr = new int[5];
		
		Book b1 = new Book("nice","robert","banana",30000);
		
		//객체 배열 선언
		Book[] b = new Book[5];
		b[0] = new Book("안녕하세요","박상은","나무",10000);
		b[1]=new Book("프로그래밍","김상은","mul",15000);
		//b[1] = new String(); //자동형변환은 불가능. 다른 타입의 객체는 넣을 수 없다.
		b[2]=new Book("어서오세요","최상은","multi",20000);
		b[3]=new Book("hello","이상은","apple",25000);
		b[4]=new Book("happy","임현성","banana",30000);
		
		Book[] bk = {
				new Book("안녕하세요","박상은","나무",10000),
				new Book("프로그래밍","김상은","mul",15000),
				new Book("어서오세요","최상은","multi",20000),
				new Book("hello","이상은","apple",25000),
				new Book("happy","임현성","banana",30000),
				b1 //이렇게도 할당 가능 Book 객체이기만 하면 된다.
				};
		
		System.out.println(bk);     //bk => 참조형, Book[]타입의 배열을 확인할 수 있다. 지금 변수가 가르키는 Book클래스 타입
		System.out.println(bk[1]);  //bk[idx] => 참조형, bk를 기준으로 bk가 가르키는 배열의 주소값. 이때 주소값은 Book클래스 객체의미
		System.out.println(bk[1].getPrice());  //bk[idx].getPirce() => 정수(기본자료형), int
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 제목 : " );
		String searchTitle = sc.nextLine();
		
		for(int i=0;i<bk.length;i++) {
			if(bk[i].getTitle().equals(searchTitle)) {
				System.out.println(bk[i].information());
			}
		}
	}
}
