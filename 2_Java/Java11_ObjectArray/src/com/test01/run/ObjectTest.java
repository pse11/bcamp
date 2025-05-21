package com.test01.run;

import java.util.Scanner;

import com.test01.model.Book;

public class ObjectTest {
	public static void main(String[] args) {
		Book b1 = new Book("안녕하세요","박상은","나무",10000);
		Book b2 = new Book("프로그래밍","김상은","mul",15000);
		Book b3 = new Book("어서오세요","최상은","multi",20000);
		Book b4 = new Book("hello","이상은","apple",25000);
		Book b5 = new Book("happy","임현성","banana",30000);
		
		
		
		System.out.println(b1.information());
		System.out.println(b2.information());
		System.out.println(b3.information());
		System.out.println(b4.information());
		System.out.println(b5.information());
		
		//도서 검색
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 책 제목: ");
		String searchTitle = sc.nextLine();
		
		if(b1.getTitle().equals(searchTitle)) {
			System.out.println(b1.information());
		}else if(b2.getTitle().equals(searchTitle)) {
			System.out.println(b2.information());
		}else if(b3.getTitle().equals(searchTitle)) {
			System.out.println(b3.information());
		}else if(b4.getTitle().equals(searchTitle)) {
			System.out.println(b4.information());
		}else if(b5.getTitle().equals(searchTitle)) {
			System.out.println(b5.information());
		}else {
			System.out.println("없습니다.");
		}
	}
}
