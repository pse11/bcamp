package com.test02.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class School {
	
	//Person을 채워주는 어노테이션
	@Autowired
	@Qualifier("kim")
	private Student person;
	
	@Value("2")
	private int grade;
	public School() {}
	public School(Student person, int grade) {
		super();
		this.person = person;
		this.grade = grade;
	}
	public Student getPerson() {
		return person;
	}
	public void setPerson(Student person) {
		this.person = person;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "person=" + person + ", grade=" + grade;
	}
	
}
