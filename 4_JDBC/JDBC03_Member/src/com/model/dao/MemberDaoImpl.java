package com.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.dto.Member;
public class MemberDaoImpl implements Memberdao{

	@Override
	public List<Member> selectAll(Connection con) {
		Statement stmt = null;
		ResultSet rs = null; //결과값을 저장할 resultset 
		List<Member> res = new ArrayList<>(); //resultset에 저장된값을 list에 옮겨 담는다.
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(selectAll);
			//rs에 들어있는 값을 한줄한줄 읽어나간다.
			while(rs.next()) {//커서 이동
				Member tmp = new Member();
				tmp.setM_no(rs.getInt(1));
				tmp.setM_name(rs.getString(2));
				tmp.setM_age(rs.getInt(3));
				tmp.setM_gender(rs.getString("M_GENDER"));
				tmp.setM_location(rs.getString(5));
				tmp.setM_job(rs.getString(6));
				tmp.setM_tel(rs.getString(7));
				tmp.setM_email(rs.getString(8));
				res.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return res;
	}

	@Override
	public Member selectOne(Connection con, int n) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Member res = new Member();
		try {
			pstm = con.prepareStatement(selectOne);
			pstm.setInt(1,n);
			rs = pstm.executeQuery();
			if(rs.next()) {
				res.setM_no(rs.getInt(1));
				res.setM_no(rs.getInt(1));
				res.setM_name(rs.getString(2));
				res.setM_age(rs.getInt(3));
				res.setM_gender(rs.getString("M_GENDER"));
				res.setM_location(rs.getString(5));
				res.setM_job(rs.getString(6));
				res.setM_tel(rs.getString(7));
				res.setM_email(rs.getString(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return res;
	}

	@Override
	public int insert(Connection con, Member m) {
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(insert);
			pstm.setString(1, m.getM_name());
			pstm.setInt(2, m.getM_age());
			pstm.setString(3, m.getM_gender());
			pstm.setString(4, m.getM_location());
			pstm.setString(5, m.getM_job());
			pstm.setString(6, m.getM_tel());
			pstm.setString(7, m.getM_email());
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}

	@Override
	public int update(Connection con, Member m) {
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(update);
			pstm.setString(1, m.getM_location());
			pstm.setString(2, m.getM_job());
			pstm.setString(3, m.getM_tel());
			pstm.setInt(4, m.getM_no());
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}

	@Override
	public int delete(Connection con, int n) {
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm= con.prepareStatement(delete);
			pstm.setInt(1, n);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}

}
