package com.test4.controller;

import com.test4.model.vo.Member;

public class MemberController /*implements Comparable<Member>*/{
	public static int SIZE = 10;
	private int memberCount;
	private Member[] mem = new Member[SIZE];
	
	{//초기화 블럭 
	mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com"); 
	mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com"); 
	mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@hanmail.net"); 
	mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gmail.com"); 
	mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com"); 
	memberCount = 5;
	}
	
	public int getMemberCount() {
		return memberCount;
	}
	public Member[] getMem() {
		return mem;
	}
	public Member checkId(String userId) {
		Member m = null; //아이디로 검색된 결과를 담을 변수 초기화
		for(int i=0;i<memberCount;i++){
			if(userId.equals(mem[i].getUserId())) {
				m=mem[i];
			}
		}
		return m;
	}
	public void insertMember(Member m) {
		mem[memberCount] = m;
		memberCount++;
	}
	public Member searchMember(int menu, String search) {
		Member searchMember = null; //검색된 회원정보를 담을 변수 초기화
		switch(menu) {
		case 1:
			for(int i=0;i<memberCount;i++) {
				if(mem[i].getUserId().equals(search)) {
					searchMember=mem[i];
				}
			}
			break;
		case 2:
			for(int i=0;i<memberCount;i++) {
				if(mem[i].getName().equals(search)) {
					searchMember=mem[i];
				}
			}
			break;
		case 3:
			for(int i=0;i<memberCount;i++) {
				if(mem[i].getEmail().equals(search)) {
					searchMember = mem[i];
				}
			}
		}
		return searchMember;
	}
	public void updateMember(Member m, int menu, String update) {
		switch(menu) {
		case 1:
			m.setUserPwd(update);
			break;
		case 2:
			m.setName(update);
			break;
		case 3:
			m.setEmail(update);
			break;
		}
	}
	public void deleteMember(String userId) {
		for(int i=0;i<memberCount;i++) {
			if(mem[i].getUserId().equals(userId)) {
				mem[i]=null; //삭제
				memberCount--; //삭제했으니 전체 count를 하나 줄여준다.
				for(int j=i;j<memberCount;j++) {
					mem[j]=mem[j+1];
				}
			}
		}
	}
	public Member[] sortIdAsc() {
		/* 강사님 설명
		 * Member[] oA = new Member[10]; 복사한 배열
		 * Member[] tmp = new Member[10]; 바꿔 넣을 빈 배열, Member가 아닌 변수여도 돌아갈 것
		 * 
		 * for(int i=0;i<memberCount-1;i++){
		 * 	for(int j=i+1;j<memberCount;j++){
		 * 		int res = oA[i].getId().compareTo(oA[j].getId());
		 * 		if(res==1){
		 * 			tmp[0]=oA[i];
		 * 			oA[i]=oA[j];
		 * 			oA[j]=tmp[0];
		 * 		}
		 * 	}
		 * }
		 * 
		 * i==0
		 * j==1~memberCount-1
		 */
		Member copy[] = new Member[memberCount];
		System.arraycopy(mem, 0, copy, 0, memberCount);
		for(int i=0;i<memberCount;i++) {
			for(int j=i+1;j<memberCount;j++) {
				int res = 
			}
		}
		return null;
	}
	public Member[] sortIdDesc() {
		return null;
	}
	public Member[] sortAgeAsc() {
		return null;
	}
	public Member[] sortAgeDesc() {
		return null;
	}
	public Member[] sortGenderDesc() {
		return null;
	}
}
