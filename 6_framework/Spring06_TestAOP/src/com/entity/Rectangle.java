package com.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("rect")
public class Rectangle extends Shape {
	
	public Rectangle() {
	}
	
	@Autowired
	public Rectangle(@Value("사각형") String title, @Value("3")int width, @Value("5")int height) {
		super(title, width, height);
	}

	@Override
	public void viewSize() {
		System.out.println(getTitle() + "의 넓이 : " + (getWidth() * getHeight()));
	}

}
