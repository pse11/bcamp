package com.test04.queue;

public class QueueMain {

	public static void main(String[] args) throws Exception{
		Queue q = new Queue(8);
		
		q.enqueue(11);
		q.enqueue(22);
		q.dump();
		q.enqueue(33);
		q.enqueue(44);
		q.dump();
		
		System.out.println("dequeue: "+q.dequeue());
		q.dump();
		System.out.println("peek: "+q.peek());
		
		System.out.println("dequeue: "+q.dequeue());
		q.dump();
		
		System.out.println("size: "+q.size());
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		
		q.dump();
		System.out.println("size: "+q.size());
	
		//q.enqueue(11);
		
		System.out.println("isEmpty: "+q.isEmpty());
		System.out.println("isFull: "+q.isFull());
		
		q.clear();
		System.out.println("isEmpty: "+q.isEmpty());
		System.out.println("isFull: "+q.isFull());
		q.dump();
		//데이터를 지우는게 아니라 덮어씌우게 되기 때문에 데이터는 남아있음. num, front, rear만 0으로 바꿔서 지운것처럼 보이게 하는것.
		
	}

}
