package com.silsub2.example;

import java.util.Scanner;

public class Exercise {
	public void excercise1() {
//		1 2 3 4 5    i=0, j=0 / i=0, j=4
//		6 7 8 9 10   i=1, j=1 / i=1, j=3
//		11 12 13 14 15	i=2, j=2
//		16 17 18 19 20  i=3,j=3 /i=3, j=1
//		21 22 23 24 25  i=4,j=4 / i=4,j=0
		//두 대각선 x의 합
		int[][] arr =new int[5][5];
		int cnt =1;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				arr[i][j]=cnt;
				cnt++;
			}
		}
		int sum =0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(i==j||i+j==4) {
					sum+=arr[i][j];
				}
			}
		}
		System.out.println("sum: "+sum);
		
	}
	public void excercise2() {
		//숫자 맞추기
		//1~100 난수 발생 시킨뒤 그 숫자를 맞추자.
		//입력한 숫자가 난수보다 작으면 "입력하신 정수보다 작습니다" 출력
		//입력한 숫자가 난수보다 크면"입력하신 정수보다 큽니다"출력
		//정답을 맞추게 되면 몇번만에 맞춘건지까지 출력하라.
		//"정답입니다. 5회 만에 정답을 맞추셨습니다.
		
		Scanner sc = new Scanner(System.in);
		int answer = (int)(Math.random()*100+1);
		int count=0;
		System.out.println("정답: "+answer);
		while(true) {
			System.out.print("숫자를 입력:");
			int input = sc.nextInt();
			System.out.println(input);
			if(answer==input) {
				count++;
				break;
			}
			if(answer<input) {
				System.out.println("입력하신 정수보다 작습니다");
				count++;
			}else if(answer>input){
				System.out.println("입력하신 정수보다 큽니다");
				count++;
			}
			
		}
		
		System.out.println("정답입니다." +count+"회 만에 정답을 맞추셨습니다.");
		
	}
}
