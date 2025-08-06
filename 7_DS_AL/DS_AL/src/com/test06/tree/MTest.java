package com.test06.tree;

public class MTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer,Data> tree = new BinarySearchTree<>();
		
		tree.add(5, new Data(5,"pse"));
		tree.add(1, new Data(1,"lcj"));
		tree.add(10, new Data(10,"jsd"));
		tree.add(12, new Data(12,"kkk")); //출력되는 순서는 왼쪽 노드, 부모 노드, 오른쪽 자식 노드(단 오른쪽 자식의 왼쪽 자식노드가 있으면 그것 먼저)
		tree.add(8, new Data(8,"hhh"));
		tree.add(9, new Data(9,"dds"));
		tree.add(13, new Data(13,"dksj"));
		tree.print();
		
		System.out.println("--------------");
		tree.remove(10);
		tree.print();
		
		System.out.println("search: "+tree.search(9));
	}

}
class Data{
	private Integer no;
	public String name;
	public Data(Integer no, String name) {
		this.no =no;
		this.name= name;
	}
	Integer keyCode() {
		return no;
	}
	public String toString() {
		return name;
	}
}
