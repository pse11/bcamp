package com.model.dao;


import java.sql.Connection;
import java.util.List;

import com.model.dto.Member;

public interface Memberdao {
	
	String selectAll = "SELECT * FROM MEMBER_JDBC";
	String selectOne = "SELECT * FROM MEMBER_JDBC WHERE M_NO=?";
	String insert = "INSERT INTO MEMBER_JDBC VALUES(SEQ_MEMBER_JDBC.NEXTVAL, ?,?,?,?,?,?,?)";
	String update = "UPDATE MEMBER_JDBC SET M_LOCATION=?, M_JOB=?, M_TEL=? WHERE M_NO=?";
	String delete = "DELETE FROM MEMBER_JDBC WHERE M_NO=?";
	
	
	public List<Member> selectAll(Connection con);
	public Member selectOne(Connection con, int n);
	public int insert(Connection con, Member m);
	public int update(Connection con, Member m);
	public int delete(Connection con, int n);
}
