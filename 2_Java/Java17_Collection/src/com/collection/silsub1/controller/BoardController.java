package com.collection.silsub1.controller;

import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
		bd.displayOne(no);
		System.out.println(bd.displayOne(no));
	}
}
