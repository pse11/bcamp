package com.silsub1.model;
import java.util.Scanner;
public class Sample {
//	[문제 1]
//			 - 메소드명 : public void munjae1()
//			 - 구현내용 :
//				1. 4행4열 2차원배열 선언 및 생성
//				2. 0행0열부터 2행2열까지 1부터 100사이의 임의의 정수값 기록해 넣음
//				3. 아래의 내용처럼 처리함
//					0열	1열	2열	3열	
//				0행	값	값	값 	0행 값들의 합계
//				1행	값	값	값	1행 값들의 합계
//				2행	값	값	값	2행 값들의 합계
//				3행	0열합계	1열합계	2열합계	가로+세로
	public void munjae1() {
		int[][] arr = new int[4][4];
		int rsum = 0;
		int csum = 0;
		for(int i=0;i<3;i++) {  //배열에 값 넣기
			int sum =0;
			for(int j=0;j<3;j++) {
				arr[i][j]=(int)(Math.random()*100+1);
				System.out.print(arr[i][j]+" ");
				sum+=arr[i][j];
				arr[i][3]=sum;
			}
			System.out.print(sum);
			System.out.println();
		}
		for(int i=0;i<3;i++) {//넣은 배열 값 가져오기
			int sum2 = 0;
			for(int j=0;j<3;j++) {
				sum2+=arr[j][i];
				arr[3][i]=sum2;
			}
			System.out.print(sum2+" ");
			}
			for(int i=0;i<3;i++) {
				rsum+=arr[i][3];
				csum+=arr[3][i];
			}
			System.out.print(rsum+csum);
		/*
		 * int[][] arr = new int[4][4];
		 *  //값 저장
		 *  for(int i=0;i<arr.length-1;i++){
		 *  	for(int j=0;j<arr[i].length-1;j++){
		 *  		arr[i][j]=(int)(Math.random() *100)+1;
		 *  	}
		 * 	}
		 * 	//계산 처리
		 * 	for(int i=0;i<arr.length-1;i++){
		 * 		for(int j=0;j<arr[i].length-1;j++){
		 * 			arr[i][3]+=arr[i][j];
		 * 			arr[3][i]+=arr[j][i];
		 *		}
		 *	}
		 *
		 *   //출력
		 *   for(int i=0;i<arr.length;i++){
		 *   	for(int j=0;j<arr[i].length;j++){
		 *   		System.out.print(arr[i][j] + "\t");
		 *   	}
		 *   	System.out.println();
		 *   }
		 */
	}
	public void munjae2() {
//		1. 3행짜리 2차원배열 선언 및 생성
//		2. 각 행별 열갯수는 키보드로 입력받아 생성함
//		3. 1~100사이의 임의의 정수를 모든 방에 기록함
//		4. 각 행별 열의 합계가 5의 배수인 행열값만 출력함
		int[][] arr = new int[3][];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++) {   //2.
			System.out.print(i+"행의 열 입력 : ");
			int j=sc.nextInt();
			arr[i]=new int[j];
		}
		for(int i=0;i<arr.length;i++) {  //3.
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=(int)(Math.random()*100+1);
			}
		}
		//4.
		for(int i=0;i<arr.length;i++) {
			int sum =0;
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+" ");
				sum+=arr[i][j];
			}
			System.out.println();
			if(sum%5==0) {
				System.out.println(i+"행");
			}
		}
		/*
		 * 
		 */
		
	}
}
