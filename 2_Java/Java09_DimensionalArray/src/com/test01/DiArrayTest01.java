package com.test01;

public class DiArrayTest01 {
	public void test1() {
		//선언
		//선언 == 변수 == stack -> 주소값이 저장된다.
		int[][] iarr1;
		int iarr2[][];
		
		//할당
		//new == heap
		iarr1 = new int[3][5]; //iarr1는 2차원배열로 선언햇기 떄문에 할당할때 다른 배열로 넣을 수 없음
		
		//배열을 저장하는 배열은 반드시 크기를 지정하며 할당
		iarr2 = new int[3][]; //[][5]는 안되지만 [3][] 이렇게는 된다. 
		System.out.println(iarr2[0]);  //null 출력
		iarr2[0] = new int[5];
		iarr2[1] = new int[3];
		iarr2[2] = new int[10];  //2차원 배열을 가변배열이라고 하기도 한다.
		
		//출력
		for(int i=0;i<iarr2.length;i++) {
			for(int j=0;j<iarr2[i].length;j++) { //반복되는 횟수를 배열의 길이로 정확하게 접근할 수 있도록 하자
				System.out.print(iarr2[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	public void test2() {
		//2차원 배열에 값을 기록
		int[][] iarr = new int[3][5];
		
		//배열 인덱스별로 직접 작성하여 접근해 값 저장
		iarr[0][0] = 1;
		iarr[0][1] = 2;
		iarr[0][2] = 3;
		iarr[0][3] = 4;
		iarr[0][4] = 5;
		
		//이중 for문을 이용하여 값 저장
		int val =1;
		for(int i=0;i<iarr.length;i++) {
			for(int j=0;j<iarr[i].length;j++) {
				iarr[i][j]=val++;
			}
		}
		//System.out.println(iarr[0][0]);
		//이중 for문을 이용하여 저장된 값 출력
		for(int i=0; i<iarr.length;i++) {
			for(int j=0;j<iarr[i].length;j++) {
				System.out.print(iarr[i][j]+" ");
			}
			System.out.println();
		}
		
		//가변배열일 경우 반복문으로 값을 저장할 때 조건식, 초기식을 잘 작성해줘야 한다. 
		iarr[0] = new int[5];
		iarr[1] = new int[3];
		iarr[2] = new int[10];
		
		val = 0;
		for(int i=0;i<iarr.length;i++) {
			for(int j=0;j<iarr[i].length;j++) {
				iarr[i][j]=++val;
				System.out.print(iarr[i][j]+" ");
			}
			System.out.println();
		}
		
	} 
	public void test3() {
		//선언및할당과 동시에 초기화
		//int[][] arr = {1,2,3}; //2차원 배열로 선언했기 때문에 숫자값을 넣는것이 아닌 배열을 넣어야한다.
		int[][] iarr = {{1,2,3},{4,5,6,7},{8,9,10,11,12}};
		
		for(int i=0;i<iarr.length;i++) {
			for(int j=0;j<iarr[i].length;j++) {
				System.out.print(iarr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void test4() {
		//구구단을 2차원 배열에 넣기
		int[][] arr = new int[8][9];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=(i+2)*(j+1);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

























