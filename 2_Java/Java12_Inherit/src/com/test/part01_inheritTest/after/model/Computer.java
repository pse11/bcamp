package com.test.part01_inheritTest.after.model;

import java.util.Date;

public class Computer extends Product{ //desktop, smartphone이 상속받을 것이다.
	private String cpu;
	private int hdd;
	private int ram;
	private String os;
	
	//생성자
	public Computer() {}

	public Computer(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os) {
		super(brand, productNumber, productCode, productName, price, date);
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
		System.out.println("Computer 객체 생성");
	}
	
	//getter&setter
	public String getCpu() {
		return cpu;
	}

	public int getHdd() {
		return hdd;
	}

	public int getRam() {
		return ram;
	}

	public String getOs() {
		return os;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	//toString
	@Override
	public String toString() {
		return super.toString()+"cpu="+ cpu + ", hdd=" + hdd + ", ram=" + ram + ", os=" + os;
	}
	
	



	
	
}
