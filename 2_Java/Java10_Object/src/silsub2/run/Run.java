package silsub2.run;

import silsub2.model.vo.Product;

public class Run {

	public static void main(String[] args) {
		Product pd = new Product();
		pd.setBrand("apple");
		pd.setpName("iphone");
		pd.setPrice(200);
		System.out.println(pd.information());
	}
}
