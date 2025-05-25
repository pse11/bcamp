package com.test4.controller;

import com.test4.model.vo.Member;

public class MemberController {
	public static final int SIZE=10;
	private int memberCount;
	private Member[] mem = new Member[SIZE];
	// 초기화 블럭을 이용하여 기본적인 회원 5명의 정보 초기화, memberCount 수 5 초기화
	{
		mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
		mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
		mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@hanmail.net");
		mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gmail.com");
		mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
		memberCount = 5;
	}

	public int getMemberCount() {
		//현재 회원 수를 나타내는	memberCount 변수값을 반환해주	는 메소드
		return memberCount;
	
	}
	public Member[] getMem() {
		//현재 회원 객체 배열의 주소 값을 반환해주는 메소드
		return mem;
	}
	public Member checkId(String userId) {
		//전달 받은 아이디가 mem 배열에 존재하는 경우 해당 아이디의 회원 정보를 반환해주는 메소드
		//(없을 경우 null 반환)
		Member m = null; // 아이디로 검색된 결과를 담을 변수 초기화
		// mem 에서 매개변수로 전달받은 userId와 동일한 아이디를 가지고 있는 회원을 m에 대입
		// m 리턴
	}
	public void insertMember(Member m) {
		//전달 받은 회원 정보를 mem 배열에 추가해주는 메소드로 회원 등록 시 memberCount 1 증가
		// 매개변수로 전달받은 회원정보를 mem 객체에 추가
		// memberCount 1 증가
	}
	public Member searchMember(int menu, String search) {
		//매개변수로 전달받은 menu에 따라 1인 경우 전달받은 search 문자열을 아이디로 검색,
		//2인 경우 이름으로 검색, 3인 경우 이메일로 검색하고 그 결과인 회원 객체 주소 값을 반환
		Member searchMember = null; // 검색된 회원 정보를 담을 변수 초기화
		// 매개변수로 전달받은 search 문자열을 menu 번호에 따라
		// 1 인 경우 아이디로 검색 후 결과를 searchMember에 대입하고
		// 2 인 경우 이름으로 검색 후 결과를 searchMember에 대입하고
		// 3 인 경우 이메일로 검색 후 결과를 searchMember에 대입하고
		// searchMember 주소 값 리턴

	}
	public void updateMember(Member m, int menu, String update) {
		//전달받은 menu에 따라 전달받은 회원 m을 setter 메소드를 이용하여 menu가 1인 경우 비밀번호 수정, 
		//2인 경우 이름 수정, 3인 경우 	이메일을 수정하는 메소드
		// 매개변수로 전달받은 m 회원과 변경 내용인 update 문자열을 menu에 따라
		// 1 인 경우 setter 메소드를 이용하여 m의 비밀번호를 update 문자열로 변경
		// 2 인 경우 setter 메소드를 이용하여 m의 이름을 update 문자열로 변경
		// 3 인 경우 setter 메소드를 이용하여 m의 이메일을 update 문자열로 변경
				
				
	}
	public void deleteMember(String userId) {
		//전달받은 아이디를 이용하여 검색 후 존재하는 경우 삭제해주는 메소드로 삭제 후 
		//다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동시킴 (memberCount 1감소)
		// 매개변수로 전달받은 userId가 mem에 존재하는 경우 해당 회원 삭제 후
		// 다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동 시킴
		// 실행 시 NullPointerException 발생할 수 있음 -> 왜그런지 생각해보고 해결하시오
		// memberCount 1 감소

	}
	public Member[] sortIdAsc() {
		//객체배열을 아이디별 오름차순 정렬한 후 주소 값 반환
		// 기존의 회원 객체 배열(mem)을 변경하지 않고 단지 정렬된 결과만을 보여주기 위해
		// 기존의 배열 복사해서 사용 (clone(), System.arraycopy() 둘 중 하나 사용해서 복사)
		Member copy[];
		// copy 배열을 아이디 별 오름차순 정렬 진행 --> HINT : compareTo() 메소드 활용
		// copy 주소 값 리턴
	}
	public Member[] sortIdDesc() {
		//객체배열을 아이디별 내림차순 정렬한 후 주소 값 반환
		// 위와 동일한 방식이지만 내림차순으로 정렬 후 주소 값 리턴
	}
	public Member[] sortAgeAsc() {
		//객체배열을 나이별 오름차순 정렬한 후 주소 값 반환
		// 위와 동일한 방식이지만 나이별 오름차순 정렬 후 주소값 리턴
		// (숫자 비교이기 때문에 compareTo 사용X)
	}
	public Member[] sortAgeDesc() {
		//객체배열을 나이별 내림차순 정렬한 후 주소 값 반환
		// 위와 동일한 방식이지만 내림차순으로 정렬 후 주소 값 리턴
	}
	public Member[] sortGenderDesc() {
		//객체배열을 성별로 내림차순 정렬(남여순) 한 후 주소 값 반환
		// 위와 동일한 방식이지만 성별 별 내림차순으로 정렬 후 주소 값 리턴
		// (남여 순으로 정렬)
	}
}
