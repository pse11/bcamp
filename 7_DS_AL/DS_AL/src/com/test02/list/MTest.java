package com.test02.list;

import java.util.Comparator;

public class MTest {
	public static void main(String[] args) {
		DoubleLinkedList<String> list = new DoubleLinkedList<>();
		
		list.addFirst("첫째");
		list.addLast("두번째");
		list.addFirst("세번째");
		list.addLast("넷째");
		list.add("마지막");
		list.dump();
		
		
		System.out.println("===============");
		list.removeFirst();
		list.removeLast();
		list.dump();
		
		System.out.println("===============");
		list.clear();
		list.dump();
		
		DoubleLinkedList<Data> list2 = new DoubleLinkedList<>();
		list2.addFirst(new Data(1,"aaa"));
		list2.add(new Data(3,"bb"));
		list2.addLast(new Data(17,"FFF"));
		list2.add(new Data(22,"Ee"));
		list2.dump();
		
		System.out.println();
		list2.removeFirst();
		list2.dump();
		
		list2.printCrntNode();
		
		System.out.println();
		Data search = list2.search(new Data(0,"bb"), new NameOrderComp());
		System.out.println("탐색: "+search);
		
		search = list2.search(new Data(22,"Ee"), new NameOrderComp());
		System.out.println("탐색: "+search);
		
	}
}
class NameOrderComp implements Comparator<Data>{

	@Override
	public int compare(Data o1, Data o2) {
		return o1.getName().compareTo(o2.getName()); //이름 기준으로 정렬
	}
	
}

class Data{
	private int no;
	private String name;
	public Data() {
		super();
	}
	public Data(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Data [no=" + no + ", name=" + name + "]";
	}
	
}