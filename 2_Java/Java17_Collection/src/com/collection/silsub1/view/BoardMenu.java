package com.collection.silsub1.view;

import java.util.Scanner;

import com.collection.silsub1.controller.BoardController;

public class BoardMenu { //사용자와 소통하는 역할, 값을 보여주고 입력하는 것
	private BoardController bc = new BoardController();
	private Scanner sc = new Scanner(System.in);
	
	
	public void mainMenu() {//화면에 메뉴 보여준다.
		
		while(true) {
			System.out.println("*****게시글 서비스*****");
			System.out.println("1.게시글 작성");
			System.out.println("2.게시글 전체 보기");
			System.out.println("3.게시글 하나 보기");
			System.out.println("9.파일에 저장하기");
			System.out.println("10.끝내기");
			
			System.out.print("메뉴 번호 선택(1~10) : ");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				//게시글 작성
				//메뉴에서는 controller가 일시킨다.
				bc.write();
				break;
			case 2:
				bc.displayAll();
				break;
			case 3:
				bc.displayOne();
				break;
			case 9:
				bc.saveList();
			case 10:
				System.out.println("프로그램 종료");
				return;
			}
		}
	}
	
}
