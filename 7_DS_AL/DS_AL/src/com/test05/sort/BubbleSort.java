package com.test05.sort;

//버블정렬
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {6,4,3,7,1,9,8};
		int[] arr2 = {6,4,3,7,1,9,8};
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("버블 정렬!");
		bubbleSort(arr,arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("버블 정렬2");
		bubbleSort2(arr2, arr2.length);
		for(int i=0;i<arr2.length;i++) {
			System.out.print(arr2[i]+" ");
		}
		System.out.println();
	}
	public static void bubbleSort(int[] a, int n) {
		for(int i=0;i<n-1;i++) {
			int cnt = 0; //초기 종료 할 조건에서 사용
			for(int j=n-1;j>i;j--) {
				if(a[j-1] > a[j]) {
					//swap
					int tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
					cnt++;
				}
			}
			if(cnt == 0) {break;} //없어도 되는 코드이지만 효율적으로 정렬할 수 있는 코드. 불필요한 반복 방지.
		}
	}
	public static void bubbleSort2(int[] a, int n) {
		//앞에서부터 인접한 요소 두개를 비교해가며
		//가장 큰값을 우측으로 밀어 정렬해 보자.
		for(int i=0;i<n-1;i++) {
			int cnt = 0;
			for(int j=0;j<n-1-i;j++) {
				if(a[j]>a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					cnt++;
				}
			}
			if(cnt==0) {break;}
		}
	}

}
