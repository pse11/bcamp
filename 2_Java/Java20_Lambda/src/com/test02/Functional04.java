package com.test02;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Functional04 {
	public static void main(String[] args) {
		//Supplier : 매개변수 x, 반환값 o
		Supplier<Integer> ran = ()->(int)(Math.random()*50+1);
		System.out.println(ran.get());
		
		//Consumer : 매개변수o, 반환값x
		Consumer<String> hello = (name)->System.out.println("hi, "+name);
		hello.accept("Lambda");
		
		//BiConsumer : 매개변수o(2개), 반환값x
		BiConsumer<String, Integer> c1 = (sub,point)->{
			System.out.println(sub+"점수: "+point);
		};
		c1.accept("Java", 99);
		
	}
}
