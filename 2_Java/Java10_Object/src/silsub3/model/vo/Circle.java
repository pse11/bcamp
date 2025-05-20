package silsub3.model.vo;

public class Circle {
	public final double PI = 3.14;
	private int radius;
	
	public Circle() {};
	
	public void setRadius(int radius) {
		this.radius=radius;
	}
	public int getRadius() {
		return radius;
	}
	
	public void incrementRadius() {
		radius++;
		System.out.println("원의 둘레:"+2*radius*PI+",넓이 : "+PI*radius*radius);
	}
	
}
