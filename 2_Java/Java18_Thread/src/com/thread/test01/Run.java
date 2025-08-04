package com.thread.test01;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Thread01 th1 = new Thread01("야옹이");
		Thread01 th2 = new Thread01("강아지");
		
		//th1.start(); -> th1.run();
		//th2.start(); -> th2.run(); 과 결과 다르다.
		
		Thread01_1 th3= new Thread01_1();
		//th3.run(); // th3입력 받을때까지 th1 기다린다.
	//	th1.run();
		//th3.start(); //입력 전에 th1의 야옹이가 다 출력된다.
		//th1.start();
		
		//우선순위 : 작업 진행이 우선순위가 높은 스레드가 먼저 진행된다.
		th1.setPriority(Thread.MIN_PRIORITY); //Thread.MIN_PRIORITY : 1
		th2.setPriority(8);
		
		th1.start();   //우선순위가 더 높은 th2가 더 많이 먼저 출력된다. 강아지 먼저 끝
		th2.start();
	}
}


class Thread01_1 extends Thread{
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		String str = sc.nextLine();
		
		System.out.println("str: "+str);
	}
}