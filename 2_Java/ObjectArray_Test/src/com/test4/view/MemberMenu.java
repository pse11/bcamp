package com.test4.view;

import java.util.Scanner;

import com.test4.controller.MemberController;
import com.test4.model.vo.Member;

public class MemberMenu {
	private MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("====회원 관리 메뉴====");
			System.out.println("1.신규 회원 관리");
			System.out.println("2.회원 정보 검색");
			System.out.println("3.회원 정보 수정");
			System.out.println("4.회원 정보 삭제");
			System.out.println("5.회원 정보 출력");
			System.out.println("6.회원 정보 정렬");
			System.out.println("9.프로그램 종료");
			int input = sc.nextInt();
			sc.nextLine();
			switch(input) {
			case 1:
				insertMember();
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAllMember();
				break;
			case 6:
				sortMember();
				break;
			case 9:
				return;
			default:
				System.out.println("다시 입력하세요");
				break;
			}
		}
	}
	public void insertMember() {
		if(mc.getMemberCount()==mc.SIZE) { //> 이렇게 하면 ArrayIndexOutofBound예외처리 에러뜬다. 
			return;
		}
		System.out.print("아이디를 입력하세요:");
		String userId = sc.nextLine();
		Member result = mc.checkId(userId);
		if(result==null) {
			System.out.print("비밀번호입력 : ");
			String userPwd = sc.nextLine();
			System.out.print("이름입력 : ");
			String name = sc.nextLine();
			System.out.print("나이입력: ");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.print("성별입력: ");
			char gender = sc.nextLine().charAt(0);
			System.out.print("이메일입력 : ");
			String email = sc.nextLine();
			Member input = new Member(userId, userPwd, name, age, gender, email);
			mc.insertMember(input);
			System.out.println("성공적으로 회원 등록 완료");
		}else {
			
			System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
		}
	}
	public void searchMember() {
		while(true) {
			System.out.println("====회원 정보 검색====");
			System.out.println("1.아이디로 검색하기");
			System.out.println("2.이름으로 검색하기");
			System.out.println("3.이메일로 검색하기");
			System.out.println("9.이전메뉴로");
			System.out.print("메뉴선택 : ");
			int menu = sc.nextInt();
			if(menu==9) {
				return;
			}
			System.out.print("검색내용 : ");
			String search = sc.next();
			Member result = mc.searchMember(menu, search);
			if(result==null) {
				System.out.println("검색된 결과가 없습니다.");
			}else {
				System.out.println(result.information());
			}
		}
	}
	public void updateMember() {
		while(true) {
			System.out.println("====회원 정보 수정====");
			System.out.println("1.비밀번호 수정");
			System.out.println("2.이름 수정");
			System.out.println("3.이메일 수정");
			System.out.println("9.이전 메뉴로");
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1: case 2: case 3:
				System.out.print("변경할 회원 아이디 : ");
				String userId = sc.next();
				sc.nextLine();
				Member m = mc.checkId(userId);
				if(m==null) {
					System.out.println("변경할 회원이 존재하지 않습니다.");
				}else {
					//기존 정보 출력 후
					System.out.println(m.information());
					//변경내용(update) 입력받고 
					System.out.print("변경내용: ");
					String update = sc.nextLine();
					// MemberController의 updateMember()에 m, menu, update 전달
					mc.updateMember(m, menu, update);
					System.out.println("회원의 정보가 변경되었습니다.");
				}
				break;
			case 9:
				return;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
			
			
		}
	}
	public void deleteMember() {
		System.out.print("삭제할 회원 아이디 :");
		String userId = sc.next();
		Member m = mc.checkId(userId);
		if(m==null) {
			System.out.println("삭제할 회원이 존재하지 않습니다.");
		}else {
			System.out.println(m.information());
			System.out.print("정말삭제하시겠습니까?(y/n): ");
			char yn = sc.next().charAt(0);
			if(Character.toUpperCase(yn)=='Y') {
				mc.deleteMember(userId);
				System.out.println("회원의 정보가 삭제되었습니다.");
			}else {
				return;
			}
		}
	}
	public void printAllMember() {
		Member[] mem = mc.getMem();
		for(int i=0;i<mc.getMemberCount();i++) {
			System.out.println(mem[i].information());
		}
	}
	public void sortMember() {
		Member[] sortMem = null;
		while(true) {
			System.out.println("====회원 정보 정렬====");
			System.out.println("1. 아이디 오름차순 정렬");
			System.out.println("2. 아이디 내림차순 정렬");
			System.out.println("3. 나이 오름차순 정렬");
			System.out.println("4. 나이 내림차순 정렬");
			System.out.println("5. 성별 내림차순 정렬(남여순)");
			System.out.println("9.  이전 메뉴로");
			System.out.print("메뉴 선택: ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				sortMem=mc.sortIdAsc();
				break;
			case 2:
				sortMem = mc.sortIdDesc();
				break;
			case 3:
				sortMem = mc.sortAgeAsc();
				break;
			case 4:
				sortMem = mc.sortAgeDesc();
				break;
			case 5:
				sortMem = mc.sortGenderDesc();
			case 9:
				return;
			default:
				System.out.println("다시 입력하세요");
				break;
			}
			for(Member m : sortMem) {
				m.information();
			}
		}
		
	}
}
