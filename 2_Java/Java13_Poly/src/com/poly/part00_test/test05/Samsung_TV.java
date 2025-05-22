package com.poly.part00_test.test05;

public class Samsung_TV implements TV{
	private int vol;

	@Override
	public int volUp() {
		vol+=3;
		return vol;
	}

	@Override
	public int volDown() {
		vol-=3;
		return vol;
	}
	
	//생성자
	public Samsung_TV() {
		System.out.println("SAMSUNG tv가 켜졌습니다.");
	}

	public void tvClose() {
		System.out.println("SAMSUNG tv가 꺼졌습니다.");
	}
}
