package com.silsub2.model;

public class Sample {
	public void munjae1(){
		//5X5 2차원배열에아래와같이1부터25까지의수를입력하시오
		//1 2 3 4 5
		//10 9 8 7 6
		int[][] arr = new int[5][5];
		int num = 1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i%2==0) {
					arr[i][j]=num;
				}else {
					arr[i][4-j]=num;
				}
				num++;
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		
		//5X5 2차원 배열에 아래와 같이 1부터 25까지의 수를 입력하시오.
//		1 6 11 16 21
//		2 7 12 17 22
//		3 8 13 18 23
//		4 9 14 19 24
//		5 10 15 20 25
		
		
	}
	public void munjae2() {
		int[][] arr = new int[5][5];
		int cnt =1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				arr[j][i]=cnt;
				cnt++;
			}
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
}
