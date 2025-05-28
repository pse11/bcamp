package com.collection.silsub3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.collection.silsub3.model.dao.BookDao;
import com.collection.silsub3.model.vo.Book;

public class BookManager {
	private BookDao bd = new BookDao();
	private Scanner sc = new Scanner(System.in);
	
	public BookManager() {}
	
	public void addBook(Book book) {
		try {
			int no = bd.getLastBookNo();
			book.setbNo(no+1+"");
			bd.addBook(book);
		}catch(IndexOutOfBoundsException e) {
			book.setbNo("1");
			bd.addBook(book);
		}
		
	}
	public Book deleteBook(String key) {
		return bd.deleteBook(key);
	}
	public String searchBook(String title) {
		return bd.searchBook(title);
	}
	public Book selectBook(String key) {
		return bd.selectBook(key);
	}
	public HashMap<String,Book> selectAll(){
		return bd.selectAll();
	}
	public Book[] sortedBookList() {
		ArrayList<Book> list = bd.sortedBookList();
		Book[] books = new Book[list.size()];
		for(int i=0;i<list.size();i++){
			books[i]=list.get(i);
		}
		return books;
	}
	public void printBookList(Book[] br) {
		for(Book b : br) {
			System.out.println(b);
		}
	}
}
