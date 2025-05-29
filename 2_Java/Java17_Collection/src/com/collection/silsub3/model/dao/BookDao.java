package com.collection.silsub3.model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.silsub3.model.vo.Book;

public class BookDao {
	//private ArrayList<Book> bookList = new ArrayList<>();
	private HashMap<String,Book> bookMap = new HashMap<String,Book>();
	
	public BookDao() {}

	public BookDao(HashMap<String,Book> map) {
		super();
		this.bookMap = map;
	}
	public int getLastBookNo() {
		//도서의 마지막 도서 번호 리턴
		//Iterator, keySet() 이용하여
		int no = 0;
		Set keys = bookMap.keySet();
		Iterator keyIt = keys.iterator();
		while(keyIt.hasNext()) {
			no++;
		}
		return no;
		
	}
	public void addBook(Book book) {
		bookMap.put(book.getbNo(),book);
	}
	public Book deleteBook(String key) {
		//keySet()을 이용하여 전달받은 도서 번호와 일치하는 도서
		//bookMap에서 삭제, 삭제한 객	체 리턴
		Book b =null;
		Set keys = bookMap.keySet();
		Iterator keysIt = keys.iterator();
		while(keysIt.hasNext()) {
			if(keysIt.next().equals(key)) {
				b= bookMap.get(keysIt);
				bookMap.remove(keysIt);
			}
		}
		return b;
	}
	public String searchBook(String title) {
//		entrySet()을 이용하여 전달받은
//		도서 제목을 포함하는
//		bookMap의 key값 리턴
		String res ="";
		Set entrys = bookMap.entrySet();
		Iterator entryIt = entrys.iterator();
		while(entryIt.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIt.next();
			Book val = (Book)entry.getValue();
			if(val.getTitle().contains(title)) {
				res = (String)entry.getKey();
			}
		}
		return res;
	}
	public Book selectBook(String key) {
		return bookMap.get(key);
	}
	public HashMap<String,Book> selectAll(){
		return bookMap;
	}
	public ArrayList<Book> sortedBookList(){
//		entrySet()을 이용하여
//		ArrayList<Book>을 가져오고
//		Collections.sort()를 이용하여
//		리스트 정렬 후 리턴
		Set entrys = bookMap.entrySet();
		Iterator entryIt = entrys.iterator();
		ArrayList<Book> booklist = new ArrayList<Book>();
		while(entryIt.hasNext()) {
			Map.Entry entry = (Map.Entry)entryIt.next();
			booklist.add((Book)entry.getValue());
		}
		Collections.sort(booklist);
		return booklist;
	}
	
}
