package com.test.chap01_encapsulation;

public class Score {
	//필드
	private String name = "박상은";
	private int kor = 90;
	private int eng = 84;
	private int math = 97;
	
	//메소드
	//생성자
	public Score() {} //메인에서 객체를 만들 때 실행된다.
	
	//1. 점수의 총합을 구해 출력하는 메소드
	public void sum() {
		System.out.println(name + "님의 점수의 총합은 "+(kor+eng+math)+"점입니다.");
	}
	//2. 점수의 평균을 구해 출력하는 메소드
	public void avg() {
		System.out.println(name+"님의 점수의 평균은 "+(int)(kor+eng+math)/3+"점입니다.");
	}
	//3. 평균을 확인하고 등급을 매기는 메소드
	//(평균 점수가 90이상 A, 70~89 B, 나머지 C)
	public void grade() {
		char grade = 'A';
		int avg = (kor+eng+math)/3;
		if(avg>=90) {
			grade='A';
		}else if(avg>=70) {
			grade='B';
		}else {
			grade='C';
		}
		System.out.println(name+"님의 등급은 "+grade+"입니다.");
	}
	//4. 필드값을 확인할 수 있게 출력해주는 메소드
	public void field() {
		System.out.println("이름: "+name+", 국어점수: "+kor+",영어점수:"+eng+",수학점수:"+math);
	}
}
