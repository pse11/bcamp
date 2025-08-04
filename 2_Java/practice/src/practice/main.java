package practice;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class main {
	public static void main(String[] args) {
		
	}
	
	public static void unaryTest() {
		UnaryOperator<String> hello = name->"Hello,"+name;
		System.out.println(hello.apply("lambda"));
	}
	public static void binaryTest() {
		BinaryOperator<Integer> sum = (i,j)->i+j;
		System.out.println(sum.apply(5, 3));
	}
}