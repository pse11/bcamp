package com.chap01_runtimeException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RunExcep {
		/*
		* 예외(Exception) : 코드 수정으로 해결 가능한 에러
		* 		-해당하는 상황이 발생되면 예외 발생 , throw 명령어를 통해 예외 발생
		* 		ex) 배열에 없는 인덱스 접근
		* 
		* RuntimeException
		* 		ArrayIndexOutofBoundsException : 배열의 접근에 잘못된 인덱스 값을 사용하는 상황
		* 		ClassCastException : 잘못된 형변환을 진행하는 상황
		* 		NullpointerException : 참조변수가 null을 가진 상황에서 메소드 호출하는 상황
		* 
		*/
	
	Scanner sc =new Scanner(System.in);
	
	public void arithEx() {
		//System.out.println(1/0);
		/*if로 처리
		System.out.print("정수 입력: ");
		int no = sc.nextInt();
		
		if(no!=0) {
			int ran = (int)(Math.random()*10)+1;
			
			int res = ran/no;
			System.out.println(ran+" / "+no+" = "+res);
			
		}else {
			System.out.println("0입력. 잘못 입력하였습니다.");
		}
		*/
		
		//try-catch
		try {
			//예외가 발생할 코드를 작성
			System.out.print("정수 입력: ");
			int no = sc.nextInt();
			
			
			int ran = (int)(Math.random()*10)+1;
				
			int res = ran/no;
			System.out.println(ran+" / "+no+" = "+res);
			
		}catch(ArithmeticException e) { //발생되는 예외를 잡아서 매개변수로 가져온다.
			//예외 발생시 실행할 코드를 작성
			//e.printStackTrace(); //발생한 예외 정보 출력
			System.out.println("0을 입력하셨습니다. 잘못입력");
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 종료");
	}
	
	public void classCatNarrayIndexEx() {
		//ClassCastException
		/*
		Object obj = 'a'; //'a'=>Character=>Object
		System.out.println(obj);
		if(obj instanceof String) {
			String str = (String)obj; //classcastexception발생
			System.out.println(str);
		}else {
			System.out.println("String이 아니다.");
		}
		*/
		try {
//			Object obj = 'ㅁ';
//			String str = (String)obj;
//			System.out.println(str);
//			
//			//ArrayIndexOutOfBoundsException
//			int[] arr = new int[2];
//			arr[0]=1;
//			arr[2]=2;
			
			//NullPointerException 널 값을 가진 참조형 변수로 메소드를 동작하려고 할때
			String str = test();
			int length = str.length();
			
		}catch(ClassCastException e) {
			System.out.println("예외 발생");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("인덱스.. 잘못 작성");
		}catch(NullPointerException e) {
			System.out.println("null... 어디야..");
		}
		finally {
			//예외가 발생하건 발생하지 않건
			//무조건 마지막에 실행
			System.out.println("실행 되나..?");
		}
		
		
	}
	public String test() {
		try {
			System.out.println("dldldl");
		}catch(ClassCastException | ArrayIndexOutOfBoundsException | NullPointerException | NegativeArraySizeException e) {
			System.out.println("런타임 익셉션");
		}		
		return null;
	}
}
