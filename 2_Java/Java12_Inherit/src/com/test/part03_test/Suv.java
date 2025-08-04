package com.test.part03_test;

public class Suv extends Car{
	public Suv() {
		
	}
	
	public Suv(String color) {
		super(color);
		System.out.println(color+"색 suv 생성");
	}
	//car와 동일한 이름으로 동일한 리턴 타입, 동일한 매개변수가 들어가는 걸 작성할 경우 
	//@Override 작성해줄 것
	@Override
	public void accelPedal() {
		System.out.println("속도가 적당히 올라갑니다.");
		super.setSpeed(super.getSpeed()+15);
	}
	
	public void bPedal() {
		System.out.println("멈춥니다.");
	}
	@Override
	public String toString() {
		return "suv의 현재 속도는 "+getSpeed() +" 입니다.";
	}
	
	
}
