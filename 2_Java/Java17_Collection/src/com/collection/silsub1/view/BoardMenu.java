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
			System.out.println("4.게시글 제목 수정");
			System.out.println("5.게시글 내용 수정");
			System.out.println("6.게시글 삭제");
			System.out.println("7.게시글 검색");
			System.out.println("8.게시글 정렬");
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
			case 4:
				bc.updateTitle();
				break;
			case 5:
				bc.updateContent();
				break;
			case 6:
				bc.delete();
				break;
			case 7:
				bc.search();
				break;
			case 8:
				sortMenu();
				break;
			case 9:
				bc.saveList();
			case 10:
				System.out.println("프로그램 종료");
				return;
			}
		}
	}
	
	public void sortMenu() {
		
		while(true) {
			System.out.println("****** 게시글 정렬 메뉴 ******");
			System.out.println("1. 글 번호 오름차순 정렬");
			System.out.println("2. 글 번호 내림차순 정렬");
			System.out.println("10. 이전 메뉴로 이동");
			System.out.print("정렬 메뉴 번호 입력: ");
			int num = sc.nextInt();
			switch(num) {
			case 1:
				bc.sortList(1,true); //1: 어떤 필드사용(글 번호), true: 오름차순, false: 내림차순
				break;
			case 2:
				bc.sortList(1,false);
				break;
			case 10:
				return;
			}
			
			
		}
	}
	
}
