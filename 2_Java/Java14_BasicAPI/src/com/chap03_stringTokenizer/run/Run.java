package com.chap03_stringTokenizer.run;

import java.util.StringTokenizer;

public class Run {
	//StringTokenizer
	//util 패키지에 있다.
	//split 차이점 : split()은 추출한 문자를 배열로 저장, stringtokenizer는 토큰으로 처리된다.
	
	//주요 메소드
	//hasMoreTokens : 토큰이 남아있는지 확인
	//nextToken() : 토큰 읽어오기
	
	public static void main(String[] args) {
		String str = "박상은,20,서울시,여";
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken()); //커서를 기준으로 옮기면서 가져온다.
		}
		String arr[] = str.split(",");
		for(String s : arr) {
			System.out.println(s);
		}
	}
}
