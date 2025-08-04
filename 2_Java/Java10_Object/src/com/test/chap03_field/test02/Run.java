package com.test.chap03_field.test02;

public class Run {

	public static void main(String[] args) {
		/*
		InitBlock ib = new InitBlock();
		ib.information();
		
		InitBlock ib2 = new InitBlock();
		ib2.information();
		*/
		InitBlock i = new InitBlock("iPhone",200,"apple"); //초기값들을 넘겨준다.
		i.information();
		
		InitBlock i2 = new InitBlock();
		i2.information();
		i.information(); //위의 i.information()과 결과값 다르다.
		
		i2.savePName("sam");
		i2.information();
	}

}
