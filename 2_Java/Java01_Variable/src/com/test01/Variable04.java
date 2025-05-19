package com.test01;

public class Variable04 {
	public static void main(String[] args) {
		//준비
		//클래스명 변수명 = new 클래스명();
		Variable04 v04 = new Variable04();
		//실행
		//변수명.메소드명()
		v04.test1();
		
		//준비
		//실행
		v04.test2();
		
		v04.test3();
		
		
	}
	
	//자동 형변환, 강제 형변환
	
	//컴퓨터의 데이터 처리 원칙
	//같은 자료형끼리 대입가능, 같은 자료형끼리 연산가능
	//작은 자료형을 큰 자료형으로, 정수형을 실수형으로 자동형변환 가능
	
	public void test1() {
		//형변환의 예외
		boolean flag = true;
		
		int num = 'A'; //자동 형변환
		System.out.println("num: " + num);
		
		char ch = 97;  //자동 형변환
		System.out.println("ch: " + ch);
		
		//num = -65; //음수 저장한 변수를 char강제 형변환 하게되면 문자로 인식할 수 없다.
		//int 변수의 값을 강제 형변환 해야 한다. 
		//char ch2 = num; //자동 형변환 안됨. num에 뭐가 있는지 모르기 때문에 강제 형변환 해줘야한다.
		char ch2 = (char)num;
		System.out.println("ch2: " + ch2);
		
	}
	
	public void test2() {
		int inum = 10;
		long lnum = 100; //숫자 뒤에 l,L 붙여야되지만 long은 괜찮음. 단, float은 무조건 f 붙여야한다.
		
		//inum + lnum => 결과 : long타입이다.
		//다른 자료형끼리 연산 후에 결과로 큰 자료형의 데이터가 나온다.
		//int isum = inum + lnum; //long->int로 바꿀 수가 없어서 에러
		
		//1.
		int isum = (int)(inum + lnum);
		//2.
		int isum2 = inum + (int)lnum;
		//3.
		long lsum = inum + lnum;
		
		System.out.printf("isum:%d, isum2:%d, lsum:%d", isum,isum2,lsum);
		
		byte bnum = 1;
		short snum = 2;
		//byte와 short은 연산 결과가 무조건 int다.
		
		//short sum = bnum + snum; 에러
		
		int sum = bnum + snum;
		short sum2 = (short)(bnum+snum);
		
	}
	public void test3() {
		long lnum = 100;
		
		float fnum = lnum;
		//정수는 실수로 자동 형변환 된다.
		System.out.println("fnum: " + fnum);
		
		//실수에서 정수로는 강제 형변환 필요
		double dnum = 1234.567;
		int inum = (int)dnum;
		
		System.out.println("inum: "+inum);
		//강제 형변환 후 데이터 손실 발생
		
	}
	
}
