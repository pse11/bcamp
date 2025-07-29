package com.test03.stack;

public class StackMain {

	public static void main(String[] args) throws Exception{
		Stack s = new Stack(16);
		
		System.out.println("size: "+ s.size());
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		s.dump();
		System.out.println("peek: "+ s.peek());
		
		s.push(5);
		s.dump();
		System.out.println("peek: "+s.peek());
		
		System.out.println("pop: "+s.pop());
		s.dump();
		System.out.println("peek: "+s.peek());
		
		System.out.println("isEmpty: "+ s.isEmpty());
		s.clear();
		System.out.println("isEmpty: "+s.isEmpty());
		
		//s.pop();
		
		s = new Stack(3);
		
		s.push(1);
		s.push(2);
		s.push(3);
		
		s.dump();
		
		System.out.println("indexOf: "+ s.indexOf(3));
		System.out.println("indexOf: "+ s.indexOf(6));
		
		s.push(4);
	}
}
