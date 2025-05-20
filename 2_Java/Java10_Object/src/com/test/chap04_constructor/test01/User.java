package com.test.chap04_constructor.test01;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private Date date;
	
	//생성자 목적 : 객체 생성, 필드 초기화하기 위해 만들어 사용함\
	//생성자 작성 : 이름은 반드시 클래스명과 동일해야한다, 리턴타입(반환형)이 없다.
	
	//기본생성자 -> 필드초기화 역할은 수행하지 못하지만
	//			객체를 생성할 때 사용이 된다.
	public User() {
		System.out.println("기본 생성자 실행");
		
	}
	
	//매개변수 있는 생성자 -> 객체 생성과 필드 초기화 두가지 목적으로 사용
	//같은 이름, 다른 매개벼수 => 오버로딩을 통해 구현했다고 말한다.
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	public User(String userId, String userPwd, String userName, Date date) {
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		//this() : 해당 클래스 내의 다른 생성자 호출
		//this();//이렇게 되면 기본생성자가 실행됨
		this(userId, userPwd, userName); //이렇게 해서 중복되는 내용을 생략할 수 있다.
		this.date = date;
	}
	
	//필드에 값을 저장하는 메소드 추가
	//setter메소드 : 필드에 값을 저장하는 메소드
	//getter메소드 : 필드에 저장된 값을 불러오는 메소드
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	
	//public void set필드명(필드타입 매개변수){
	//	필드 = 매개변수;
	//}
	
	//public 필드타입 get필드명(){
	//	return 필드;
	//}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	} 
	//출력용 메소드
	public void info() {
		System.out.println(userId+", "+userPwd+", "+userName+","+date);
		
		
	}
}