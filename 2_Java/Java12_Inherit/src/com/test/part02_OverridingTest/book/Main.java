package com.test.part02_OverridingTest.book;

public class Main {

	public static void main(String[] args) {
		Book b1 = new Book("안녕하세요", "김상은", 10000);
		Book b2 = new Book("Hello","박상은",20000);
		
		System.out.println("b1 = "+b1);
		System.out.println("b2 = "+b2);
		
		//System.out.println("b1 =" +b1.toString());
		//System.out.println("b2 =" +b2.toString());
		
		//toString을 book클래스에 만들지 않음 : 
		//부모것을 내것으로 쓸 수 있기 때문에 book클래스의 부모는 object. 
		//object의 tostring이 실행된다.
		
		System.out.println("b1과 b2가 같나? : "+b1.equals(b2));
		//같은 공간인지. 해시코드로 비교한다. 
		
		Book b3 = b1;
		System.out.println("b1과 b3가 같나? : "+b1.equals(b3));
		
		//b1과 같은 내용의 b4
		Book b4 = new Book("안녕하세요","김상은",10000);
		System.out.println("b1과 b4가 같나? : "+b1.equals(b4));
		//b1과 값이 동일 객체 b4는 false
		
		System.out.println(b1.hashCode());
		System.out.println(b4.hashCode());
		
		//주소 값은 다르지만 값이 같은 객체 : 동등하다라고 한다.
		//hashCode까지 같으면 동일하다라고 한다.
		//equals()의 값이 true인데 hashCode()가 다르면
		//다른 객체로 취급될 수 있다.
		//그래서 hashCode()도 overriding 해줘야한다.
		
	}

}
