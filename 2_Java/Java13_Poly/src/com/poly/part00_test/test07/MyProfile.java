package com.poly.part00_test.test07;

public class MyProfile extends Profile implements Display, Job {
	private String loc;

	
	public MyProfile(String name, String phone) {
		super(name,phone); //자식클래스 객체를 만들때 부모 생성자 호출하면서 만들어지는데 이때 super("","")없으면 에러.
		
	
	}
	@Override
	public void jobLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public void display() {
		super.printProfile();
		System.out.println("회사 주소: "+loc);
		System.out.println("회사 직종: "+jobId);
	}
	
	
}
