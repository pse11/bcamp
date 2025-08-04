package com.test03;

public class Engineer extends Emp{
	private String dept;

	public Engineer() {
		super();
	}

	public Engineer(String name, int salary, String dept) {
		super(name, salary);
		this.dept=dept;
	}

	@Override
	public String toString() {
		return super.toString()+"\t 부서: "+ dept ;
	}


}
