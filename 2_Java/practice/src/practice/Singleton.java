package practice;
public class Singleton{
	private static Singleton one = new Singleton();
    
    private Singleton(){}
    
    static Singleton getInstance(){
    	return one;
    }
}