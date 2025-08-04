package com.poly.silsub1.shape.model;

public class Rectangle /*extends Shape*/ implements IShape{
	private double width;
	private double height;
	
	public Rectangle() {}
	public Rectangle(double with, double height) {
		super();
		this.width = with;
		this.height = height;
	}
	public double getWith() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void setWith(double with) {
		this.width = with;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	

	@Override
	public double area() {
		return width*height;
	}

	@Override
	public double perimeter() {
		return (width+height)*2;
	}
	
}
