package com.test02.list;

import java.util.Comparator;

public class DoubleLinkedList<E> {
	
	//노드 생성
	class Node<E>{
		private E data;  //데이터 저장
		private Node<E> prev;   //앞쪽 노트
		private Node<E> next;  //뒤쪽 노드에 대한 참조
		
		//생성자
		Node(){
			data = null;
			prev = this; //본인을 가르킴
			next = this;
		}
		Node(E obj, Node<E> prev, Node<E> next){
			data = obj;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node<E> head;
	private Node<E> crnt;
	
	//생성자
	public DoubleLinkedList() {
		head = crnt = new Node<E>(); //더미 노드 생성
	}
	
	//기능 구현
	public boolean isEmpty() {
		return head.next == head; //head의 next를 확인했을 때 본인(head)이면 비어있는것.
	}
	
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head.next;
		while(ptr != head) {
			if(c.compare(obj, ptr.data)==0) { //같은 거다.
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null; //검색 실패
	}
	
	//crnt가 가르키는 노드 확인
	public void printCrntNode() {
		if(isEmpty()) {
			System.out.println("노드가 없습니다.");
		}else {
			System.out.println(crnt.data);
		}
	}
	
	//리스트 전체 노드 확인
	public void dump() {
		Node<E> ptr = head.next;
		while(ptr != head) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
	
	//노드 추가
	public void add(E obj) {
		Node<E> node = new Node<E>(obj, crnt, crnt.next);
		
		crnt.next = crnt.next.prev = node;
		crnt = node;
	}
	//제일 앞에 노드 추가
	public void addFirst(E obj) {
		crnt = head;
		add(obj);
	}
	//제일 뒤에 노드 추가
	public void addLast(E obj) {
		crnt = head.prev;
		add(obj);
	}
	
	//노드 삭제
	public void removeCrnt() {
		if(!isEmpty()) {
			crnt.prev.next = crnt.next;
			crnt.next.prev = crnt.prev;
			crnt = crnt.prev;
			if(crnt==head) {
				crnt = head.next;
			}
		}
	}
	//첫번째 노드 삭제
	public void removeFirst() {
		crnt = head.next;
		removeCrnt();
	}
	//마지막 노드 삭제
	public void removeLast() {
		crnt = head.prev;
		removeCrnt();
	}
	
	//전체 삭제
	public void clear() {
		while(!isEmpty()) {
			removeCrnt();
		}
	}
}
