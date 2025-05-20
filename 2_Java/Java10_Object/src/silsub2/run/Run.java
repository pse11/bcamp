package silsub2.run;

import silsub2.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		Product pd = new Product();
		
		pd.setPName("iphone");
		pd.setPrice(100);
		pd.setBrand("apple");
		
		System.out.println(pd.information());
		
	}

}
