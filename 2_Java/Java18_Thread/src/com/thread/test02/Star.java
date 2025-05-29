package com.thread.test02;

public class Star implements Runnable{

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				for (int k = 0; k < 30; k++) {
					System.out.println();
				}
				
				for (int j = 0; j < i; j++) {
					System.out.print("  ");
				}
				System.out.println("🤍");

				for (int j = 0; j < i; j++) {
					System.out.print("  ");
				}
				System.out.println("🌈");
				
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
