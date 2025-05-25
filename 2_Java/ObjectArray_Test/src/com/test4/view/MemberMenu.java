package com.test4.view;

import java.util.Scanner;

import com.test4.controller.MemberController;
import com.test4.model.vo.Member;

public class MemberMenu {
	private MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		//반복문을 이용하여 메인 메뉴를 반복적으로 실행(각 메뉴 별 서브 메뉴 호출)
		// 메뉴 출력 >> 반복 실행 처리함
//		====== 회원 관리 메뉴 ======
//		1. 신규 회원 등록 >> insertMember() 실행
//		2. 회원 정보 검색 >> searchMember() 실행
//		3. 회원 정보 수정 >> updateMember() 실행
//		4. 회원 정보 삭제 >> deleteMember() 실행
//		5. 회원 정보 출력 >> printAllMember() 실행
//		6. 회원 정보 정렬 >> sortMember() 실행
//		9. 프로그램 종료
		while(true) {
			System.out.println("=====회원 관리 메뉴=====");
			int select = sc.nextInt();
			switch(select) {
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
			case 9:
				return;
			default:
				System.out.println("숫자를 다시 입력해주세요");
				break;
			}
		}

	}
	public void insertMember() {
		//메인 메뉴에서 1번 선택시 실행되는 메소드이며 등록할 회원에 대한 정보를 입력 받고 동일한 아이디가 없는 경우 MemberController의 insertMember 메소드 실행
		// 1. 현재 회원 수(memberCount)가 최대 회원 수(SIZE)를 넘어설 경우 return 처리
		// 2. 아이디를 입력 받아 MemberControllerdml checkId() 메소드로 전달 >> 결과 값
		// 2_1. 결과 값이 null이 아닌 경우 즉, 동일한 아이디가 존재하는 경우
		// “동일한 아이디가 존재합니다. 회원등록 실패” 출력
		// 2_2. 결과 값이 null인 경우 즉, 동일한 아이디가 존재하지 않는 경우
		// 나머지 회원 정보 입력 받도록 (비밀번호, 이름, 나이, 성별, 이메일)
		// 입력 받은 정보를 Member의 매개변수 생성자를 이용하여 객체 생성 후
		// MemberController의 insertMember() 메소드로 전달
		// “성공적으로 회원 등록이 되었습니다.” 출력
		if(mc.getMemberCount()>mc.SIZE) {
			return;
		}
		System.out.print("아이디를 입력해주세요:");
		String userId = sc.next();
		if(mc.checkId(userId)!=null) {
			System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
		}else if(mc.checkId(userId)==null) {
			System.out.print("비밀번호입력 : ");
			String userPwd = sc.next();
			System.out.print("이름입력: ");
			String name = sc.next();
			System.out.print("나이입력:");
			int age = sc.nextInt();
			System.out.print("성별입력:");
			char gender = sc.next().charAt(0);
			System.out.print("이메일입력:");
			String email = sc.next();
			mc.insertMember(new Member(userId, userPwd, name, age, gender, email));
			System.out.println("성공적으로 회원 등록이 되었습니다.");
		}

	}
	public void searchMember() {
		//메인 메뉴에서 2번 선택시 실행되는 서브메뉴-> 반복 실행
		//각 서브메뉴에 해당하는 검색 내용을 입력 받고 MemberController의 searchMember 메소드 실행
		// 메뉴 출력 >> 반복 실행 처리함
//		====== 회원 정보 검색 ======
//		1. 아이디로 검색하기
//		2. 이름으로 검색하기
//		3. 이메일로 검색하기
//		9. 이전 메뉴로
//		메뉴 선택 : >> 키보드로 입력 받기 (menu : int)
//		검색 내용 : >> 키보드로 입력 받기 (search : String)
		// 1. MemberController의 searchMember() 메소드로 menu와 search 문자열 전달 >> 결과 값
		// 1_1. 결과 값이 null인 경우 즉, 검색 결과가 없는 경우 >> “검색된 결과가 없습니다.” 출력
		// 1_2. 결과 값이 null이 아닌 경우 즉, 검색 결과가 존재하는 경우 >> 회원 정보 출력
		
		
	}
	public void updateMember() {
		//메인 메뉴에서 3번 선택시 실행되는 서브메뉴->반복실행
		// 각 서브메뉴에서 해당하는 수정할 내용을 입력 받고 MemberController의 updateMember 메소드 실행
		// 메뉴 출력 >> 반복 실행 처리함
//		====== 회원 정보 수정 ======
//		1. 비밀번호 수정
//		2. 이름 수정
//		3. 이메일 수정
//		9. 이전 메뉴로
//		메뉴 선택 : >> 키보드로 입력 받기 (menu : int)
//		변경할 회원 아이디 : >> 키보드로 입력 받기 (userId : String)
		// 1. MemberController의 checkId로 userId 전달 >> 결과 값 (m : Member)
		// 1_2. 결과 값이 null인경우 >> “변경할 회원이 존재하지 않습니다” 출력
		// 1_2. 결과 값이 null이 아닌 경우 기존 정보 출력 후
		// 변경내용(update) 입력 받고
		// MemberController의 updateMember()에 m, menu, update 전달
		// “회원의 정보가 변경되었습니다.” 출력
	}
	public void deleteMember() {
		//메인 메뉴에서 4번 선택시 실행되는 메소드이며 삭제할 회원 아이디를 입력 받고
		//MemberController의 deleteMember 메소드 실행
//		삭제할 회원 아이디 : >> 키보드로 입력 받기 (userId : String)
		// 1. MemberController의 checkId()에 userId 전달 >> 결과 값 (m : Member)
		// 1_1. 결과 값이 null인 경우 “삭제할 회원이 존재하지 않습니다.” 출력
		// 1_2. 결과 값이 null이 아닌 경우 기존 정보 출력
		// “정말 삭제하시겠습니까? (y/n) : “ >> 키보드로 입력 받기
		// 대소문자 구분 없이 ‘Y’인 경우 MemberController의 deleteMember()에 userId 전달
		// “회원의 정보가 삭제되었습니다.” 출력

	}
	public void printAllMember() {
		//메인 메뉴에서 5번 선택시 실행되는 메소드
		//MemberController의 getMem 메소드 실행의 결과 값을 반복문을 통해 출력
		// MemberController의 getMem() 메소드 호출 >> 결과 값 (mem : Member[])
		// 반복문을 통해 결과 값 안의 존재하는 회원들 정보 출력
		
	}
	public void sortMember() {
		//메인 메뉴에서 6번 선택시 실행되는 서브메뉴 -> 반복실행
		//각 서브메뉴에 해당하는 MemberController의 정렬 메소드들을 실행함으로써 그 결과 값으로 반복문을 통해 출력
//		Member[] sortMem = null; // 정렬 결과를 받아 줄 객체배열 초기화
//		// 메뉴 출력 >> 반복 실행 처리함
//		====== 회원 정보 정렬 ======
//		1. 아이디 오름차순 정렬 >> MemberController의 sortIdAsc() 결과 sortMem에 대입
//		2. 아이디 내림차순 정렬 >> sortIdDesc() 결과 sortMem에 대입
//		3. 나이 오름차순 정렬 >> sortAgeAsc() 결과 sortMem에 대입
//		4. 나이 내림차순 정렬 >> sortAgeDesc() 결과 sortMem에 대입
//		5. 성별 내림차순 정렬(남여순) >> sortGenderDesc() 결과 sortMem에 대입
//		9. 이전 메뉴로
//		메뉴 선택 : >> 키보드로 입력 받기 (menu : int)
		// 반복문을 통해 sortMem 객체 배열 출력

	}
}
