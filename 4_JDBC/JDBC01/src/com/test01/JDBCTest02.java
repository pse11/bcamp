package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//jdbc를 통해
		//사번, 사원명, 직급명, 부서명, 급여를 조회하여
		//출력문으로 출력해 확인
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521/orcl";
		//localhost ==127.0.0.1
		String id = "MULTI";
		String pw = "MULTI";
		
		Connection con = DriverManager.getConnection(url,id,pw);
		Statement stmt = con.createStatement();
		String sql = "SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, SALARY, BONUS"+
					" FROM EMPLOYEE E "+
					"JOIN JOB J ON (E.JOB_CODE=J.JOB_CODE)"+
					" JOIN DEPARTMENT ON (DEPT_CODE=DEPT_ID)";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("사번 사원명 직급명 부서명 급여");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
					rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
		}
		rs.close();
		stmt.close();
		con.close();
	}
}
