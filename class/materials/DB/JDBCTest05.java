package com.test01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static common.JDBCTemplate.*;

public class JDBCTest05 {
	public static void main(String[] args) throws SQLException {
		//[1] inesrt
		//Scanner를 이용하여 번호,이름,별명을 입력받아
		//MYTEST 테이블에 저장.
		//insert();
		
		//[2] select 
		//그리고 저장 후 조회해서 콘솔에 출력.
		//select();
		
		//추가 
		//while문을 추가하여 반복하기.
		//ex)메뉴- 1.추가 2.조회 3.종료
		Scanner sc = new Scanner(System.in);
		int no = 0;
		do {
			System.out.println("---메뉴---");
			System.out.println("1. 추가");
			System.out.println("2. 조회");
			System.out.println("3. 종료");
			System.out.print("번호 입력: ");
			no = sc.nextInt();
			
			switch(no) {
			case 1:
				insert();
				break;
			case 2:
				select();
				break;
			case 3:
				System.out.println("프로그램 종료");
				return;
			}
		}while(true);
				
	}
	public static void insert() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호: ");
		int no = sc.nextInt();
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("별명: ");
		String nickName = sc.next();
		
		String sql  = " INSERT INTO MYTEST VALUES("+no+", '" 
						+name+"', '" + nickName+"') ";
		
		//import static common.JDBCTemplate.*; 추가
		con = getConnection();
		stmt = con.createStatement();
		int res = stmt.executeUpdate(sql);
		
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		close(stmt);
		close(con);
	}
	public static void select() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM MYTEST ";
		
		con = getConnection();
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		
		close(rs);
		close(stmt);
		close(con);
		
	}
	
}



















