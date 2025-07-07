package com.test01;

public class Phone extends Product{
	private String mobileAgency;

	public Phone() {
	}
	public Phone(String pname, int price) {
		super(pname, price);
	}
	
	public String getMobileAgency() {
		return mobileAgency;
	}
	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	@Override
	public String toString() {
		return super.toString() + ", mobileAgency="+mobileAgency;
	}

	
}
