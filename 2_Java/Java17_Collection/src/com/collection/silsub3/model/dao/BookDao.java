package com.collection.silsub3.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.collection.silsub2.model.comparator.AscCategory;
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
		Set keys = bookMap.keySet();
		Iterator keysIt = keys.iterator();
		while(keysIt.hasNext()) {
			if(keysIt.next().equals(key)) {
				//Map.Entry entry = (Map.Entry)
				bookMap.remove(keysIt);
			}
		}
		return 
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
	public Book selectBook(int index) {
		return bookMap.get(index);
	}
	public HashMap<String,Book> selectAll(){
		return bookMap;
	}
	public ArrayList<Book> sortedBookList(){
		bookMap.sort(new AscCategory());
		return bookMap;
	}
	
}
