package com.test02.controller;

import java.util.Scanner;

import com.test02.model.vo.Person;

public class PersonController {
	private Person[] p = new Person[3];
	Scanner sc = new Scanner(System.in);
	public void insertPerson() {
		//회원 추가
		for(int i=0;i<3;i++) {
			System.out.println("== 회원 정보 입력 ==");
			System.out.print("이름: ");
			String name = sc.next();
			System.out.print("나이: ");
			int age = sc.nextInt();
			System.out.print("재산: ");
			int wealth = sc.nextInt();
			
			//입력한 값 person객체에 저장하고 p배열에 저장
			p[i] = new Person(name,age,wealth);
		}
	}
	public void printPerson() {
		//회원 전체 조회
//		for(int i=0;i<3;i++) {
//			String name= p[i].getName();
//			int age = p[i].getAge();
//			int wealth = p[i].getWealth();
//			System.out.println("이름 : "+name+",나이 : "+age+",재산 : "+wealth);
//		}
		
		//향상된 for문
		for(Person people : p) {
			System.out.println(people.info());
		}
	}
	
	public void avgWealth() {
		//회원 평균재산
		int sum = 0;
		for(Person people : p) {
			sum+=people.getWealth();
		}
		System.out.println("평균 재산 : "+sum/p.length);
	}
	
	public void searchName() {
		//회원 이름 검색
		//키보드로 입력받은 이름과 같은 회원을 찾아
		//화면에 출력	
		System.out.print("회원 이름 : ");
		String name = sc.next();
		for(Person people : p) {
			if(name.equals(people.getName())) {
				System.out.println("이름 : "+people.info());
			}
		}
//		for(int i=0;i<p.length;i++) {
//			if(p[i].getName().equals(name)) {
//				System.out.println(p[i].info());
//			}
//		}
	}
	//MVC패턴(디자인) - CONTROLLER역할? 개념 한번 찾아보자
		
	//
}
