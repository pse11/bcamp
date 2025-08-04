package com.chap02_throw;

import java.io.IOException;

public class MTest {
	//throw
	//throws
	public static void main(String[] args) /*throws IOException*/{
		try {
			testA();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void testA() throws IOException{
		testB();
	}
	public static void testB() throws IOException{
		testC();
	}
	public static void testC() throws IOException{
		System.out.println("Hi");
		/*
		try {
			throw new IOException(); //예외 발생~
		}catch(IOException e) {
			e.printStackTrace();
		}
	
		*/
		throw new IOException(); //예외 발생~
		//예외처리를 해야한다.
		//1. trycatch : 예외가 발생하는 그 위치에서 예외를 처리하겠다.
		//2. throws : 예외 처리를 나를 호출한 곳으로 넘긴다.
		
	}
}
