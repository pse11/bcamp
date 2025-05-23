package com.chap04_wrapperclass.run;

public class Run {
	//wrapper 클래스
	//프로그램에 따라 기본타입의 데이터가 아닌 객체로 취급해야 하는 경우 활용
	//ex)메소드 실행 시 매개변수로 객체타입만 요구하는 경우
	//Object클래스와 관련된 메소드 활용할때
	
	//8개의 기본타입에 해당하는 데이터를 객체로 만들 수 있는 wrapper클래스가 각각 존재한다.
	
	//Boxing : 기본자료형 => wrapper클래스 객체
	//UnBoxing : wrapper클래스 객체 => 기본자료형
	public static void main(String[] args) {
		//boxing
		Integer i = new Integer(10); //줄 : deprecated
		Integer i2 = new Integer(10);
		Integer i3 = 15; //리터럴을 바로 대입
		//객체화 => boxing => 자동으로 boxing==autoBoxing
		
		System.out.println(i==i2); //false ,주소값이 다름 ,객체이기 때문에 비교연산자로는 비교안됨
		System.out.println(i.equals(i2)); //true , 안에 있는 값을 비교,
		//객체화되어있는 상태에서는 비교연산자 불가능~!
		System.out.println(i3.equals(i));
		System.out.println(i.compareTo(i3)); //-1
		//i3가 크면 음수(-1), i가 크면 양수(1), 같으면 0
		
		Short i4 = 10;
		Double d1 = 10.0;
		
		int no = 10;
		Integer noObj = no;
		
		//Unboxing
		int pi = i.intValue();
		double pd = d1.doubleValue();
		System.out.println(pi);
		System.out.println(pd); 

		//AutoUnBoxing
		int a = i;
		double d = d1;
		int b = i3;
		
		ab(a+b); //int >> (autoboxing) >> Integer 객체 >> (다형성) >> Object obj
		
		test1();
	}
	public static void ab(Object obj) {
		System.out.println(obj);
		int o1 = (Integer)obj;
	}
	
	public static void test1() {
		//String => primitive
		byte b = Byte.parseByte("1");
		int i = Integer.parseInt("4");
		double d = Double.parseDouble("1.0");
		char c = "a".charAt(0);
		
		b = Byte.valueOf("1");
		i = Integer.valueOf("1");
		
		//primitive => String
		String str = b+"";
		str = ((Integer)i).toString();
		str = Integer.valueOf(1).toString();
		System.out.println(str);
		
		
	}
}
