package com.my.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoardDto;

public class MyBoardDao {
	public List<MyBoardDto> selectAll(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MyBoardDto> res = new ArrayList<>();
		String sql = " SELECT * FROM MYBOARD ORDER BY MYNO DESC ";
		
		try {
			stmt = con.createStatement();
		    rs = stmt.executeQuery(sql);
		    while(rs.next()) {
		    	MyBoardDto dto = new MyBoardDto();
		    	dto.setMyno(rs.getInt(1));
		    	dto.setMyname(rs.getString(2));
		    	dto.setMytitle(rs.getString(3));
		    	dto.setMycontent(rs.getString(4));
		    	dto.setMydate(rs.getDate(5));
		    	res.add(dto);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		return res;
	}
}
