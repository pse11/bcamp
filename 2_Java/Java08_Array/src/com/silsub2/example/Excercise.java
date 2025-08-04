package com.silsub2.example;

public class Excercise {
	public void exc1() {
		int count = 1;
		int sum = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i==j || i+j==4) {
					sum+=count;
				}
				System.out.print(count+" ");
				count++;
			}
			System.out.println();
		}
		System.out.println("sum:"+sum);
	}
	public static void main(String[] args) {
		new Excercise().exc1();
	}
}
