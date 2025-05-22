package com.poly.part00_test.test06;

public abstract class AreaImpl implements Area{
	
	private String result;
	@Override
	public void print() {
		System.out.println(Area.print + result);
	}
	
	public void setResult(String result) {
		this.result=result;
	}
	
}
