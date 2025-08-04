package com.test.chap03_field.test02;

public class InitBlock {
/*	
* 	1. 기본값   //결과 : null, 0, null
	private String pName; //외부에서 접근 x
	private int price;
	private static String brand;
	*/
	//2.명시적 초기화  //결과 : iphone, 200, apple
	private String pName = "iPhone";
	private int price = 200;
	private static String brand = "apple";
	
	//3. 초기화 블럭
	static {
		//static 초기화 블럭
		//프로그램이 실행되면 이 블럭이 실행된다.
		brand = "samsung";
		
		//static필드만 접근 가능
		//pName="fold"; 
	} 
			
	{
		//인스턴스 초기화 블럭
		pName ="flip";
		price = 150;
		brand = "삼성";    
	}
	
	//4.매개변수 있는 생성자를 이용
	public InitBlock() {}//기본생성자
	//매개변수 있는 생성자 : 위의 초기화된 값을 덮어쓰고 전달받은 값을 초기화
	public InitBlock(String pName, int price, String brand) { //해당 객체를 생성할 때 값 3개를 넘겨준다.
		//넘겨받는 값을 가지고 각필드에 초기화를 시켜준다.
		this.pName=pName; //각 매개변수를 필드값에 넣어준다.
		this.price= price;  //this : 생성되는 객체 자체.
		InitBlock.brand = brand;
		
		//new로 방들이 만들어지고 initblock과 같은 걸로 초기화.
		//매개변수로 각 필드에 집어넣는다.
		
	}	
	//4.5 값을 저장하는 메소드 (비어있는 객체를 만들고 값을 넣어준다.)
	public void savePName(String pName) {
		this.pName= pName; //필드 pName에 매개변수 pName값을 저장한다.
	}
	//setter 메소드
	//public void set필드이름(필드타입 매개변수)
	//		해당필드의 값 변경하는 코드
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	//실행되는 시점 : 인스턴스 초기화가 static초기화보다 더 늦게 실행
	
	public void information() {
		System.out.println(pName+","+price+","+brand+" "); //필드 값 출력
	}
}
