package com.silsub1;

public class Transaction {
	/*
	 * -field : private Trader trader;
		          private int year;
		          private int value;
		-method : 생성자(기본,매개변수), getter&setter, toString
	 */
	private Trader trader;
	private int year;
	private int value;
	public Transaction() {}
	public Transaction(Trader trader, int year, int value) {
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}
	public Trader getTrader() {
		return trader;
	}
	public int getYear() {
		return year;
	}
	public int getValue() {
		return value;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "trader=" + trader + ", year=" + year + ", value=" + value;
	}
	
}
