package com.collection.silsub3.view;

import java.util.Iterator;
import java.util.Scanner;

import com.collection.silsub3.controller.BookManager;
import com.collection.silsub3.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookManager bm = new BookManager();
	
	public BookMenu() {}
	public void mainMenu() {
		while(true) {
			System.out.println("======도서관리 프로그램======");
			System.out.println("1.새 도서 추가");
			System.out.println("2.도서정보 정렬 후 출력");
			System.out.println("3.도서 삭제");
			System.out.println("4.도서 검색 출력");
			System.out.println("5.전체 출력");
			System.out.println("6.끝내기");
			System.out.print("번호 입력: ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1:
				Book ib = inputBook();
				bm.addBook(ib);
				break;
			case 2:
				bm.printBookList(bm.sortedBookList());
				break;
			case 3:
				//삭제할 도서 번호 입력
				String result = bm.deleteBook(inputBookNo());
				if(result==null) {
					System.out.println("삭제할 글이 존재하지 않음");
				}else{
					System.out.println("성공적으로 삭제");
				}
				break;
			case 4:
				String key = bm.searchBook(inputBookTitle());
				if(key==null) {
					System.out.println("조회한 글이 존재하지 않음");
				}else {
					// selectBook(index) 출력
					System.out.println(bm.selectBook(key));
				}
				break;
			case 5:
				// 결과 map 리턴 받아 비어있을 경우 “없습니다.”
				//아닐 경우 Iterator, keySet()을 이용하여 전체 출력
				if(bm.selectAll().isEmpty()) {
					System.out.println("없습니다.");
				}else {
					//iterator이용하여 전체 출력
					Iterator bookIt = bm.selectAll().iterator();
					while(bookIt.hasNext()) {
						Book b = (Book)bookIt.next();
						System.out.println(b);
					}
				}
				
				break;
			case 6:
				System.out.println("프로그램 종료");
				return;
			}
		}
		
	}
	public Book inputBook() {
		System.out.print("도서 제목: ");
		String title = sc.nextLine();
		System.out.print("도서 장르(1:인문/2:자연과학/3:의료/4:기타): ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.print("도서 저자: ");
		String author = sc.nextLine();
		Book b = new Book(category,title,author);
		return b;
	}
	public String inputBookNo() {
		System.out.print("삭제할 도서번호 입력: ");
		String bNo = sc.nextLine();
		return bNo;
	}
	public String inputBookTitle() {
		System.out.print("검색할 도서제목 입력: ");
		String title = sc.nextLine();
		return title;
	}
}
