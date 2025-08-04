package com.test.part02_OverridingTest.book;

public class Book {
	//필드
	private String title;
	private String writer;
	private int price;
	
	//생성자
	//기본생성자
	public Book() {}
	//매개변수생성자
	public Book(String title, String writer, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	//getter&setter
	public String getTitle() {
		return title;
	}
	public String getWriter() {
		return writer;
	}
	public int getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return title+", "+writer+", "+price;
	}
	
	//equal() 오버라이딩
	//저장된 값을 비교해서 같은지 확인
	@Override
	public boolean equals(Object obj) { //Object obj = b4
		if(this==obj){ //this : b1 , 두개의 주소가 같냐? o-> 같은 객체다
			return true;
		}
		if(obj == null) { //obj가 참조하는 게 없다 : 무조건 b1과 다른것.
			return false;
		}
		
		//두개의 주소가 다를때
		//전달받은 객체의 필드값과 현재 객체의 필드값을 비교
		//object 포장지를 벗긴다.= 안에있는 Book클래스를 꺼낸다.
		//형변환
		Book other = (Book)obj;
		other.getTitle();
		//obj.getTitle(); obj에는 getTitle이 없다. 편하게 사용하기 위해 obj를 형변환 해준다. 
		
		//원본의 제목이 null이면 비교할 객체의 제목도 null이어야 한다.
		//그렇지 않은 경우를 찾아서 false를 리턴한다.
		if(this.title == null) { //현재 객체의 해당하는 필드(여기선 b1)
			if(other.title!=null) {
				return false;
			}else {
				return true;
			}
		//두 객체의 title에 저장된 값이 다른 경우를 찾아서 false를 리턴한다.
		}else if(!this.title.equals(other.title)) {
			return false;
		}
		
		//작가
		if(writer==null) {
			if(other.writer != null) {
				return false;
			}
		}else if(!this.writer.equals(other.writer)) {
			return false;
		}
		
		//가격, 기본자료형
		if(price!=other.price) {
			return false;
		}
		
		//모든 조건을 통과하면 두 객체는 같은 객체다.
		return true;
	}
	
	@Override
	public int hashCode() {
		//"안녕하세요김상은10000".hashCode()가 리턴된다.
		return (title+writer+price).hashCode();
	}
	
	
	
}
