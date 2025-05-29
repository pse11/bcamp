package com.thread.test01;

//2. Runable 상속
public class Thread02{ 
	public static void main(String[] args) {//여기서 스레드 총 3개 (main 까지)
		//main은 빠르게 끝나버린다.
		System.out.println("---ㅡmain start----");
		MyThread mt = new MyThread();
		
		Thread t1 = new Thread(mt); //thread클래스로 객체 만들어줘야한다.
		Thread t2 = new Thread(new MyThread());
		
		//start() => 자동으로 run() 실행
		t1.start();
		t2.start();
		
		System.out.println("----main end----");
		//모든 스레드가 종료되어야 프로세스가 종료된다.
	}
	
}

class MyThread implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("i="+i);
		}
	}

}