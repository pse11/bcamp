package com.silsub1.objArr.run;

import com.silsub1.objArr.model.vo.Student;

public class Run {
	public static void main(String[] args) {
		Student[] arr = new Student[3];
		
		arr[0] = new Student(3,1,1,"홍길동");
		arr[1] = new Student(4,3,2,"유관순");
		arr[2] = new Student(2,7,5,"윤봉길");
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].information());
		}
	}
}
