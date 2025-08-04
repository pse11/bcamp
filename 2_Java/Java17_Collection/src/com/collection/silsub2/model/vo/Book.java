package com.collection.silsub2.model.vo;

public class Book {
	private int bNo;
	private int category;
	private String title;
	private String author;
	
	public Book() {}

	public Book(int category, String title, String author) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
	}

	public int getbNo() {
		return bNo;
	}

	public int getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "[bNo=" + bNo + ", category=" + category + ", title=" + title + ", author=" + author + "]";
	}
	
}
