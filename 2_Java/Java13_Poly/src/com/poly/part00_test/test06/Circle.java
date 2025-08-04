package com.poly.part00_test.test06;

import java.util.Scanner;

public class Circle extends AreaImpl{

	@Override
	public void make() {
		//면적을 구하기 위한 수치값들 입력받는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름 : ");
		int r = sc.nextInt();
		
		double res = Math.PI*r*r;
		//super.setResult(res+"");  //double 타입인 res를 string으로 바꿔주는 가장 간단한 방법
		super.setResult(String.format("%.2f", res));
	}
	
	@Override
	public void print() {
		System.out.print("원의 ");
		super.print();
	}
}
