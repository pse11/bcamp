package com.test.part03_test;

public class Car {
	private String color;
	private int speed;
	
	//생성자(기본, 매개변수)
	public Car() {
		super();
	}
	public Car(String color, int speed) {
		super();
		this.color = color;
		this.speed = speed;
	}
	//getter,setter
	public String getColor() {
		return color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Car(String color) {
		this.color=color;
	}
	//기능 구현
	public void accelPedal() {
		System.out.println("속도가 올라갑니다.");
		setSpeed(getSpeed()+10);
	}
	public void breakPedal() {
		setSpeed(getSpeed()-10);
		
		if(getSpeed()>0) {
			System.out.println("속도가 줄어듭니다.");
		}else {
			setSpeed(0);
			System.out.println("멈췄습니다.");
		}
	}
	@Override
	public String toString() {
		return "현재 속도는" +speed+"입니다.";
	}
}
