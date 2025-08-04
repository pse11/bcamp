package com.collection.silsub1.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.collection.silsub1.model.comparator.AscBoardNo;
import com.collection.silsub1.model.comparator.DescBoardNo;
import com.collection.silsub1.model.dao.BoardDao;
import com.collection.silsub1.model.vo.Board;

public class BoardController {
	private BoardDao bd = new BoardDao();
	private Scanner sc = new Scanner(System.in);
	
	public void write() {
		//게시물 작성 및 추가
		System.out.println("[새 게시글 쓰기]");
		
		System.out.print("글제목: ");
		String title = sc.nextLine();
		System.out.print("작성자: ");
		String writer = sc.nextLine();
		
		System.out.print("내용(exit입력 시 종료): ");
		//여러줄 입력받기
		String content = "";
		String str = "";
		
		while(true) {
			str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			content+=str;
		}
		//첫 게시글 입력에만 예외 발생
		try {
			Board b = new Board(bd.getLastNo()+1,title,writer,new Date(),content);
			bd.write(b);
		}catch(IndexOutOfBoundsException e) {
			//해당 예외가 발생하는 경우는
			//list에 객체가 하나도 없을 경우 발생한다.
			Board b = new Board(1,title,writer,new Date(),content);
			bd.write(b);
		}
	}
	public void displayAll() {
		//리스트를 받아와서 출력해준다.
		List<Board> list = bd.displayAll();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	public void saveList() {
		bd.saveList();
	}
	
	public void displayOne() {
		//게시글 번호 입력받아
		//해당 게시글출력
		System.out.print("게시글 번호 입력: ");
		int no = sc.nextInt();
		//bd.displayOne(no);
		//System.out.println(bd.displayOne(no));
		Board board = bd.displayOne(no);
		if(board==null) {
			System.out.println("조회된 글이 없습니다.");
		}else {
			System.out.println(board);
		}
	}
	
	public void updateTitle() {
		//수정하고자하는 게시글 번호를 입력받는다.
		System.out.print("수정할 게시글 번호 입력: ");
		int no = sc.nextInt();
		
		Board board = bd.displayOne(no);
		if(board ==null) {
			System.out.println("해당 번호의 글이 없습니다.");
		}else {
			//수정하고자하는 제목을 입력받는다.
			System.out.print("수정할 제목 입력: ");
			sc.nextLine();//엔터가 남아있어서 다 날려줘야한다. scanner의 단점
			String title = sc.nextLine();
			//수정 작업 진행(dao)
			bd.updateTitle(no, title);
			displayAll();
		}
		
	}
	
	public void updateContent() {
		//수정하고자 하는 게시글 번호 입력받기
		//있는지 확인
		System.out.print("수정할 게시글 번호 입력: ");
		int no = sc.nextInt();
		Board board = bd.displayOne(no);
		if(board==null) {
			System.out.println("게시물이 존재하지 않습니다.");
		}else {
			//수정할 내용 입력
			System.out.print("수정할 내용 입력(exit시 종료): ");
			sc.nextLine();
			String content = sc.nextLine();
			bd.updateContent(no, content);
			displayAll();
		}
	}
	
	public void delete() {
		System.out.print("삭제할 게시글 번호 입력: ");
		int no = sc.nextInt();
		sc.nextLine();
		Board board = bd.displayOne(no);
		if(board==null) {
			System.out.println("존재하지 않는 게시물입니다.");
		}else {
			//삭제
			System.out.print("정말로 삭제하시겠습니까?(y/n): ");
			/*char ch =sc.next().charAt(0);
			if(ch=='y' &&ch=='Y') {
				bd.delete(no);
				displayAll();
			}
			*/
			char ch = sc.next().toUpperCase().charAt(0);
			if(ch=='Y') {
				bd.delete(no);
				System.out.println(no+"번 게시글 삭제 완료");
			}
		}
	}
	
	public void search() {
		//검색할 게시글의 제목 입력
		System.out.print("검색할 게시글 제목 입력: ");
		String title = sc.nextLine();
		
		//검색
		ArrayList<Board> res = bd.search(title); //있을 수도 없을 수도 있다.
		
		if(res.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			//검색 결과 출력
			for(Board b:res) {
				System.out.println(b);
			}
		}
	}
	
	public void sortList(int field,boolean isAsc) {
		//매개변수
		//정수값: 어떤 필드를 정렬할지
		//논리값 : true-> 오름차순, false->내림차순
		
		ArrayList<Board> list = bd.displayAll();
		switch(field) {
		case 1: //글 번호 정렬
			//field == 1-> boardno를 정렬하겠다
			if(isAsc) {
				//true일때
				//오름차순 하겠다.
				list.sort(new AscBoardNo());
			}else {
				//내림차순 하겠다.
				list.sort(new DescBoardNo());
			}
			break;
		}
		//정렬 후 리스트 출력
		for(Board b : list) {
			System.out.println(b);
		}
	}
	
}
