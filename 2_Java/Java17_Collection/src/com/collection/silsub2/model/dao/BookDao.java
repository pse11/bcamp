package com.collection.silsub2.model.dao;

import java.util.ArrayList;

import com.collection.silsub2.model.comparator.AscCategory;
import com.collection.silsub2.model.vo.Book;

public class BookDao {
	private ArrayList<Book> bookList = new ArrayList<>();
	
	public BookDao() {}

	public BookDao(ArrayList<Book> list) {
		super();
		this.bookList = list;
	}
	public int getLastBookNo() {
		return bookList.get(bookList.size()-1).getbNo();
	}
	public void addBook(Book book) {
		bookList.add(book);
	}
	public int deleteBook(int no) {
		int res=1;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getbNo()==no) {
				bookList.remove(i);
				res = 0;   //삭제 성공
			}
		}
		return res;
	}
	public int searchBook(String title) {
		int idx=-1;
		for(int i=0;i<bookList.size();i++) {
			if(bookList.get(i).getTitle().contains(title)) {
				idx=i;
			}
		}
		return idx;
	}
	public Book selectBook(int index) {
		return bookList.get(index);
	}
	public ArrayList<Book> selectAll(){
		return bookList;
	}
	public ArrayList<Book> sortedBookList(){
		bookList.sort(new AscCategory());
		return bookList;
	}
	
}
