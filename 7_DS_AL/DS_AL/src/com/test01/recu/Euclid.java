package com.test01.recu;

public class Euclid {
	//유클리드 호제법 (두 수의 최대공약수 구하는 알고리즘)\
	public static void main(String[] args) {
		int gcd = euclid(8,24);
		System.out.println("최대공약수:" +gcd);
	}
	public static int euclid(int n1, int n2) {
		if(n2==0) {
			return n1;
		}else {
			return euclid(n2,n1%n2);
		}
	}
}
