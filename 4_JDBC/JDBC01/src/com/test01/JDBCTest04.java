package com.test01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import static common.JDBCTemplate.*;
public class JDBCTest04 {
	//INSERT
	public static void main(String[] args) throws SQLException {
		//준비
		Connection con = null;
		Statement stmt = null;
		//INSERT 실행에서는 ResultSet필요없다.
		
		int no = 2;
		String name = "KIM";
		String nickName ="kkkk";
		
		//INSERT INTO MYTEST VALUES(1,'LEE','TTTT');
		String sql = " INSERT INTO MYTEST VALUES("+no+",'"+name+"','"+nickName+"') ";
		// => " INSERT INTO MYTEST VALUES(2,'KIM','kkkk') "
		
		//연결
		con = getConnection();
		
		//쿼리 실행 및 결과 처리
		stmt = con.createStatement();
		int res = stmt.executeUpdate(sql);
		//적용된 로우의 수를 int값으로 리턴
		
		if(res>0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		
		//종료 시작한것의 역순으로 해줘야함
		close(stmt);
		close(con);
		
	}
}
