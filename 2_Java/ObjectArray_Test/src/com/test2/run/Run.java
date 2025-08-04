package com.test2.run;

import java.util.Scanner;

import com.test2.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		Student[] sarr = new Student[10];
		int count=0;
		Scanner sc = new Scanner(System.in);
		while(count<10) {
			System.out.print("학년:");
			int grade = sc.nextInt();
			System.out.print("반:");
			int classroom = sc.nextInt();
			System.out.print("이름:");
			String name = sc.next();
			System.out.print("국어:");
			int kor = sc.nextInt();
			System.out.print("영어:");
			int eng=sc.nextInt();
			System.out.print("수학:");
			int math=sc.nextInt();
			
			sarr[count]=new Student(grade,classroom,name,kor,eng,math);
			count++;
			System.out.print("계속 추가하시겠습니까?");
			char input = sc.next().charAt(0);
			if(input=='y'||input=='Y') {
				continue;
			}else {
				break;
			}
		}
		for(int i=0;i<sarr.length;i++) {
			if(sarr[i]!=null) { //이걸 안하면 null포인트 에러가 뜬다.
				System.out.println(sarr[i].information());
			}else {
				break;
			}
			
		}
	}

}
