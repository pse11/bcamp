package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static common.JDBCTemplate.*;
public class JDBCTest06 {

	public static void main(String[] args) throws SQLException {
		//preparedStatement활용하여 insert
		
		//준비
		Connection con = null;
		PreparedStatement pstm = null;	
		
		int no = 17;
		String name = "CHOI";
		String nickName = "CCCC";
		
		//statement
		//String sql = "INSERT INTO MYTEST VALUES("+no+",'"+name+"','"+nickName+"')";
		//preparedStatement
		String sql = "INSERT INTO MYTEST VALUES(?,?,?)"; // ? : 미리 값이 들어갈 공간 확보 -> 3개 값이 들어간다.
		
		//연결
		con = getConnection();
		
		pstm = con.prepareStatement(sql);
		pstm.setInt(1, no); //첫번째 ? 에 no를 채워넣는다.
		pstm.setString(2, name);
		pstm.setString(3, nickName);
		
		int res = pstm.executeUpdate();
		
		if(res>0) {
			System.out.println("insert 성공"); 
			con.commit();
		}else {
			System.out.println("insert 실패");
		}
	
		
		close(pstm);
		close(con);
		
	}
}
