package com.test02;

import com.test01.MethodTest01;

public class MethodTest03 /*extends MethodTest01*/{
	public static void main(String[] args) {
		MethodTest01.publicMethod();  //다른 패키지에 있기 때문에 import해줘야함.
		//MethodTest01.protectedMethod();
		//MethodTest01.defaultMethod();
		//MethodTest01.privateMethod();
		
	}
}
