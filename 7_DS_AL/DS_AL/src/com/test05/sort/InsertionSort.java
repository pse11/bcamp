package com.test05.sort;

//삽입 정렬
public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {6,4,1,7,3,9,8};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		System.out.println("삽입정렬");
		insertionSort(arr,arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void insertionSort(int[] a, int n) {
		for(int i=1;i<n;i++) { // [5,2,3,1] 의 경우 2부터 앞으로 삽입하기 때문에 i=1부터 시작 맨앞의 5는 이미 정렬이 되어있다고 가정
			int j; //타겟 왼쪽의 원소들을 비교하기 위한 커서 역할
			int tmp = a[i]; //비교하려하는 원소(타겟)
			for(j=i; j>0 && a[j-1]>tmp;j--) {
				a[j]=a[j-1]; //앞에 있는 게 더 크니까 뒤로 한칸 미루겠다.
			}
			a[j] = tmp;
		}
	}

}
