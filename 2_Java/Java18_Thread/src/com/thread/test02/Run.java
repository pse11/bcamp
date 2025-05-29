package com.thread.test02;

public class Run {

	public static void main(String[] args) {
		Thread th1 = new Thread(new Heart());
		Thread th2 = new Thread(new Star());
		
		try {
			th1.start();
			Thread.sleep(500);
			th2.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
