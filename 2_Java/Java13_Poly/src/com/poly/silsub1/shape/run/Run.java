package com.poly.silsub1.shape.run;

import com.poly.silsub1.shape.controller.ShapeController;

public class Run {
	public static void main(String[] args) {
		new ShapeController().calcShape();
	}
	
	//추상클래스 Shape을
	//새로만든 인터페이스 IShape으로 변경해보자
}
