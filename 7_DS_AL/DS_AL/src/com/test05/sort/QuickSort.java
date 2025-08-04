package com.test05.sort;

//퀵 정렬
//피벗 기준으로 나눠서 정렬
//속도 빠르다
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {5,8,4,2,6,1,3,9,7};
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void quickSort(int[] a, int left, int right) { //left: 맨왼쪽 인덱스, right: 맨오른쪽 인덱스
		int lc = left;
		int rc = right;
		int x = a[(lc+rc)/2]; //배열의 가운데 쯤을 피벗으로 잡는다.
		
		do {
			while(a[lc]<x) {lc++;} //피벗보다 적으면 lc를 ++,다음 칸 이동하다가 피벗보다 큰 값을 찾으면 스탑.
			while(a[rc]>x) {rc--;} 
			
			// do while문 모두 종료되었다! => 피벗 왼쪽에서 피벗보다 큰 값을 찾았다.
			//							  피벗 우측에서 피벗보다 작은 값을 찾았다.
			
			if(lc<=rc) {
				int tmp = a[lc];
				a[lc] = a[rc];
				a[rc] = tmp;
				lc++;
				rc--;
			}
		}while(lc<=rc); //lc가 rc넘어서면 종료
		
		if(left<rc) {
			quickSort(a,left,rc);
		}
		if(right>lc) {
			quickSort(a,lc,right);
		}
	}
}
