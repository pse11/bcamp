package com.test05.sort;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {6,4,3,7,1,9,8};
		
		mergeSort(arr, arr.length);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static int[] buff;
	public static void mergeSort(int[] a, int n) {
		buff = new int[n];
		
		mSort(a,0,n-1);
	}
	public static void mSort(int[] a, int left, int right) {
		if(left<right) {
			int center = (left+right)/2;
			int p=0;
			int j=0;
			int k=left;
			
			//center를 기준으로 왼쪽 배열 영역으로 mSort()실행
			mSort(a,left,center);//반을 쪼개 나눔
			mSort(a,center+1,right);
			
			//이 부분이 실행 = 배열을 다 나눴다
			for(int i=left;i<=center;i++) {
				buff[p++] = a[i];
			}
			
			//병합
			int i=center+1;
			while(i<=right && j<p) {
				a[k++] = (buff[j]<=a[i]) ? buff[j++] : a[i++];
			}
			//버퍼에 남은 데이터를 a에 복사
			while(j<p) {
				a[k++] = buff[j++];
			}
		}
	}
}
