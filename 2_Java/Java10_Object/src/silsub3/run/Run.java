package silsub3.run;

import silsub3.model.vo.*;
public class Run {

	public static void main(String[] args) {
		Circle cl = new Circle();
		Circle c2 = new Circle();
		cl.setRadius(4);
		System.out.println(c2.getRadius());
		
		System.out.println("원둘레:" +2*cl.PI*cl.getRadius()+"원 넓이: "+cl.PI*cl.getRadius()*cl.getRadius());
		cl.incrementRadius();
		System.out.println("원둘레:" +2*cl.PI*cl.getRadius()+"원 넓이: "+cl.PI*cl.getRadius()*cl.getRadius());
	}

}
