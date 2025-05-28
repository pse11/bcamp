package com.collection.part03_map.hashmap;

import java.util.Objects;

public class Score {
	private String name;
	private int point;
	public Score() {}
	public Score(String name, int point) {
		super();
		this.name = name;
		this.point = point;
	}
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
	
	@Override
	public String toString() {
		return "[name=" + name + ", point=" + point + "]";
	}
	
	//같은 값이 들어있으면 같은 객체로 판단할 수 있게 해줌. 중복 불가하게 해줌
	@Override
	public int hashCode() {
		return Objects.hash(name, point);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(name, other.name) && point == other.point;
	}
	
	
}
