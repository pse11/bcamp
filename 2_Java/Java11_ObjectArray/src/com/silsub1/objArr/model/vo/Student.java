package com.silsub1.objArr.model.vo;

public class Student {
	//필드
	private int grade;
	private int classroom;
	private int number;
	private String name;
	
	//기본 생성자
	public Student() {}
	//매개변수 생성자
	public Student(int grade, int classroom, int number, String name) {
		this.grade=grade;
		this.classroom=classroom;
		this.number = number;
		this.name=name;
	}
	public int getGrade() {
		return grade;
	}
	public int getClassroom() {
		return classroom;
	}
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String information() {
		return grade +"학년 "+classroom+"반 "+number+"번 "+name;
	}
}
