package com.test3.controller;

import java.util.Scanner;

import com.test3.model.vo.Product;

public class ProductController {
	private Product[] pro = new Product[10];
	
	public static int count = 0;
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		do {
			System.out.println("====제품 관리 메뉴====");
			System.out.println("1.제품 정보 추가");// productInput() 메소드 실행
			System.out.println("2.제품 전체 조회");// productPrint() 메소드 실행
			System.out.println("9.프로그램 종료");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				productInput();
				break;
			case 2:
				productPrint();
				break;
			case 9:
				return;
			default:
				System.out.println("다시 입력하세요");
				break;
			}
		}while(true);
	}
	public void productInput() {
		// 제품 추가
		System.out.println("===제품 정보 추가===");
		System.out.print("제품 번호: ");
		int pId = sc.nextInt();
		System.out.print("제품명:");
		String pName = sc.next();
		System.out.print("제품 가격: ");
		int price = sc.nextInt();
		System.out.print("제품 세금: ");
		double tax = sc.nextDouble();
			
		pro[count] = new Product(pId, pName, price,tax);
		
	}
	public void productPrint() {
		//제품 출력
		for(int i=0;i<count;i++) {
			System.out.println(pro[i].information());
		}
	}
}
