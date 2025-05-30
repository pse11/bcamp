package com.silsub1;

import java.util.Arrays;
import java.util.List;

public class Silsub01 {
	public static void main(String[] args) {
		Trader raoul = new Trader("kim", "Seoul");
		Trader mario = new Trader("lee", "Suwon");
		Trader alan = new Trader("park", "Busan");
		Trader brian = new Trader("choi", "Incheon");

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2021, 500),
				new Transaction(raoul, 2022, 1200), 
				new Transaction(raoul, 2021, 300),
				new Transaction(mario, 2022, 620), 
				new Transaction(mario, 2022, 810),
				new Transaction(alan, 2022, 990));
	}
}
