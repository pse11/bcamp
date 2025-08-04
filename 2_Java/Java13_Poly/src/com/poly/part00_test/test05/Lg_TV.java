package com.poly.part00_test.test05;

public class Lg_TV implements TV{
	private int vol;

	//생성자
	public Lg_TV() {
		System.out.println("LG TV가 켜졌습니다.");
	}
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	@Override
	public int volUp() {
		vol++;
		return vol;
	}

	@Override
	public int volDown() {
		vol--;
		return vol;
	}

	public void tvClose() {
		System.out.println("LG tv가 꺼졌습니다.");
	}
}
