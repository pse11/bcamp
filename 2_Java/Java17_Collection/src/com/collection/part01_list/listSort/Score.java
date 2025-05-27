package com.collection.part01_list.listSort;

public class Score implements Comparable<Score>{ //인터페이스이니까 추상메소드 오버라이딩 해줘야한다.
	private String name;
	private int point;
	
	
	//생성자(기본, 매개변수)
	public Score() {}
	
	public Score(String name, int point) {
		super();
		this.name = name;
		this.point = point;
	}
	
	

	//getter, setter
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "[name=" + name + ", point=" + point + "]";
	}

	@Override
	//name 오름차순 정렬
	public int compareTo(Score o) {
		//비교되는 두 값을 기준으로
		//양수를 리턴하면 바꾼다. 음수를 리턴하면 안바꾼다.
		
		String otherName = o.getName(); //기준이 되는 객체와 이름 비교
		
		return name.compareTo(otherName);
		//음수->자리 안바꿈
		//양수->자리 바꿈
		//0 -> 제자리
		
		//String의 기본정렬기준인 오름차순을 그대로 따라서
		//name 오름차순 정렬된다.
		
		//"나".compareTo("가"); ==> 양수
		// 바꿀꺼다 => 양수 그대로 리턴,
		//안바꿀꺼다 => 음수로 리턴
	}
}
