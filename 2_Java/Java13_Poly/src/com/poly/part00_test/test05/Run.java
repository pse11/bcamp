package com.poly.part00_test.test05;

public class Run {

	public static void main(String[] args) {
		Samsung_TV stv = new Samsung_TV();

		System.out.println(stv.volUp());
		System.out.println(stv.volDown());
		stv.tvClose();
		
		Lg_TV ltv = new Lg_TV(); //객체 생성
		System.out.println(ltv.volUp());
		System.out.println(ltv.volUp());
		System.out.println(ltv.volUp());
		
		System.out.println(ltv.volDown());
		System.out.println(ltv.volDown());
		
		ltv.tvClose();
	}
}
