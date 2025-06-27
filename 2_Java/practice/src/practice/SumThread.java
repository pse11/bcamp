package practice;

public class SumThread extends Thread{
	public boolean work = true;
	
	public SumThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName()+":작업처리");
			}else {
				Thread.yield();
			}
		}
	}
}
