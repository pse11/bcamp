package silsub3.model.vo;

public class Circle {
	public final double PI=3.14;
	private int radius;

	public Circle() {}

	public double getPI() {
		return PI;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void incrementRadius() {
		this.radius=radius++;
	}
}
