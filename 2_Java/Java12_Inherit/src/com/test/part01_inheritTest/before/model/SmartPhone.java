package com.test.part01_inheritTest.before.model;

import java.util.Date;

public class SmartPhone {
	//필드
	private String brand;			
	private String productNumber;	
	private String productCode;		
	private String productName;		
	private String cpu;	
	private int hdd;
	private int ram;
	private String os;
	private int price;
	private Date date;
	private String mobileAgency;
	
	//gettet&setter  우클릭 source 사용
	public void setBrand(String brand) {this.brand=brand;}
	@Override
	public String toString() {
		return "SmartPhone [brand=" + brand + ", productNumber=" + productNumber + ", productCode=" + productCode
				+ ", productName=" + productName + ", cpu=" + cpu + ", hdd=" + hdd + ", ram=" + ram + ", os=" + os
				+ ", price=" + price + ", date=" + date + ", mobileAgency=" + mobileAgency + "]";
	}
	public void setProductNumber(String productNumber) {this.productNumber=productNumber;}
	public void setProductCode(String productCode) {this.productCode=productCode;}
	public void setProductName(String productName) {this.productName=productName;}
	public void setCpu(String cpu) {this.cpu=cpu;}
	public void setHdd(int hdd) {this.hdd= hdd;}
	public void setRam(int ram) {this.ram=ram;}
	public void setOs(String os) {this.os=os;}
	public void setPrice(int price) {this.price=price;}
	public void setDate(Date date) {this.date= date;}
	public void setMobileAgency(String mobileAgency) {this.mobileAgency=mobileAgency;}
	
	public String getBrand() {return brand;}
	public String getProductNumber() {return productNumber;}
	public String getProductCode() {return productCode;}
	public String getProductName() {return productName;}
	public String getCpu() {return cpu;}
	public int getHdd() {return hdd;}
	public int getRam() {return ram;}
	public String getOs() {return os;}
	public int getPrice() {return price;}
	public Date getDate() {return date;}
	public void getMobileAgency(String mobileAgency) {this.mobileAgency=mobileAgency;}
	
	//prn() : 필드값 출력
	
	public void prn() {
		System.out.println(brand+","+productNumber+","+productCode+","+productName+","+cpu+","+hdd+","+ram+","+os+","+price+","+date+","+mobileAgency);
	}
	
	public SmartPhone() {
		super();
		
	}
	public SmartPhone(String productName, String cpu, int hdd, int ram, String os, int price, Date date,
			String mobileAgency) {
		super();
		this.productName = productName;
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
		this.price = price;
		this.date = date;
		this.mobileAgency = mobileAgency;
	}
}
