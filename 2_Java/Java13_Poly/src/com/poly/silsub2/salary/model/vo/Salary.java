package com.poly.silsub2.salary.model.vo;

public abstract class Salary {
	private String name;
	private long pay;
	private long familyP; 
	private long overtimeP;	//시간외수당   
	private long incenP;//성과금   
	private long tax;		//세금  
	private long totalPay;	//실수령액
    private int family;	//가족수    
    private int overtime;	//초과근무시간
    private static float incentive =0.5f; //인센티브 - 초기값(0.5)
    private static int count =0;       //총인원 - 초기값(0)
    
    public Salary() {}
	public Salary(String name, long pay, long familyP, long overtimeP, long incenP, long tax, long totalPay, int family,
			int overtime) {
		super();
		this.name = name;
		this.pay = pay;
		this.familyP = familyP;
		this.overtimeP = overtimeP;
		this.incenP = incenP;
		this.tax = tax;
		this.totalPay = totalPay;
		this.family = family;
		this.overtime = overtime;
	}
	public Salary(String name, long pay, int family, int overtime) {
		this.name=name;
		this.pay=pay;
		this.family=family;
		this.overtime=overtime;
		count++;
	}
	public String getName() {
		return name;
	}
	public long getPay() {
		return pay;
	}
	public long getFamilyP() {
		return familyP;
	}
	public long getOvertimeP() {
		return overtimeP;
	}
	public long getIncenP() {
		return incenP;
	}
	public long getTax() {
		return tax;
	}
	public long getTotalPay() {
		return totalPay;
	}
	public int getFamily() {
		return family;
	}
	public int getOvertime() {
		return overtime;
	}
	public static float getIncentive() {
		return incentive;
	}
	public static int getCount() {
		return count;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPay(long pay) {
		this.pay = pay;
	}
	public void setFamilyP(long familyP) {
		this.familyP = familyP;
	}
	public void setOvertimeP(long overtimeP) {
		this.overtimeP = overtimeP;
	}
	public void setIncenP(long incenP) {
		this.incenP = incenP;
	}
	public void setTax(long tax) {
		this.tax = tax;
	}
	public void setTotalPay(long totalPay) {
		this.totalPay = totalPay;
	}
	public void setFamily(int family) {
		this.family = family;
	}
	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}
	public static void setIncentive(float incentive) {
		Salary.incentive = incentive;
	}
	public static void setCount(int count) {
		Salary.count = count;
	}
    
    
}
