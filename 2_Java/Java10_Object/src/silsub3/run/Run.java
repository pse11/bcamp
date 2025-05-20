package silsub3.run;

import silsub3.model.vo.*;
public class Run {

	public static void main(String[] args) {
		Circle cl = new Circle();
		cl.setRadius(5);
		int r= cl.getRadius();
		System.out.println("원의 둘레 : "+(2*cl.PI*r)+", 넓이: "+r*r*cl.PI);
		cl.incrementRadius();
	}

}
