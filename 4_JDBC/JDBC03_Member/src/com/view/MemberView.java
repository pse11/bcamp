package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.MemberController;
import com.model.dto.Member;

public class MemberView {
	MemberController controller = new MemberController();
	Scanner sc = new Scanner(System.in);
	public void menu() {
		int no=0;
		while(no!=6) {
			System.out.println("-----------------------");
			System.out.println("1.전체출력");
			System.out.println("2.선택출력");
			System.out.println("3.추가");
			System.out.println("4.수정");
			System.out.println("5.삭제");
			System.out.println("6.종료");
			System.out.println("-----------------------");
			System.out.print("번호 입력 : ");
			no = sc.nextInt();
			switch(no) {
			case 1:
				//전체출력
				System.out.println("***전체 출력***");
				List<Member> resSelAll = controller.selectAll();
				for(Member m : resSelAll) {
					System.out.println(m);
				}
				break;
			case 2:
				System.out.println("***선택 출력***");
				System.out.print("번호 입력 : ");
				int n = sc.nextInt();
				Member resSelOne = controller.selectOne(n);
				if(resSelOne.getM_name()!=null) { //dao에서 Member객체 = null로 선언했기 때문에 값을 찾지 못하면 null 값이 저장된 객체가 출력되기 때문에 이 조건을 넣어줘야한다. 
					System.out.println(resSelOne);
				}else {
					System.out.println("일치하는 데이터가 없습니다.");
				}
				break;
			case 3:
				System.out.println("***추가***");
				int res =controller.insert(insertMember());
				if(res>0) {
					System.out.println("insert 성공");
				}else {
					System.out.println("insert 실패");
				}
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("\n[프로그램 종료]\n");
				return;
			}
		}
	}
	public Member insertMember() {
		System.out.println("추가할 이름: ");
		String name = sc.next();
		System.out.println("추가할 나이: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("추가할 성별: ");
		String gender = sc.nextLine();
		System.out.println("추가할 지역: ");
		String location = sc.nextLine();
		System.out.println("추가할 직업: ");
		String job = sc.nextLine();
		System.out.println("추가할 번호: ");
		String tel = sc.nextLine();
		System.out.println("추가할 이메일: ");
		String email = sc.nextLine();
		
		return new Member(0,name,age,gender,location,job,tel,email);
	}
}
