package com.test01;

public class TV {
	private Product product;
	private int inch;
	public TV() {
	}
	public TV(Product product, int inch) {
		super();
		this.product = product;
		this.inch = inch;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	@Override
	public String toString() {
		return  product + ", inch=" + inch;
	}
	
	
	
}
