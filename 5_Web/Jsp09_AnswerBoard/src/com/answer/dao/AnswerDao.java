package com.answer.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;
public class AnswerDao {
	public List<AnswerDto> selectAll(Connection con){
		Statement stmt = null;
		ResultSet rs = null;
		List<AnswerDto> res = new ArrayList<>();
		String sql = " SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSQ ";
		try {
			stmt = con.createStatement();
			System.out.println("03.query준비: "+sql);
			rs = stmt.executeQuery(sql);
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				AnswerDto dto = new AnswerDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8));
				res.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return res;
	}
	public int insert(Connection con, AnswerDto dto) {
		PreparedStatement pstm = null;
		int res = 0;
		
		//INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,GROUPNOSQ.NEXTVAL,1,0,'첫번째 글','1번 글 입니다!!','유저1',SYSDATE);
		String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL, GROUPNOSQ.NEXTVAL,1,0,?,?,?,SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			System.out.println("03. query준비: "+sql);
			res = pstm.executeUpdate();
			System.out.println("04. query실행 및 리턴");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		
		return res;
	}
	public AnswerDto selectOne(Connection con, int boardno) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto res = null;
		String sql = " SELECT * FROM ANSWERBOARD WHERE BOARDNO=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			rs = pstm.executeQuery();
			if(rs.next()) {
				res = new AnswerDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}
	public int update(Connection con, AnswerDto dto) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE ANSWERBOARD SET TITLE=?, CONTENT=? WHERE BOARDNO=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getBoardno());
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public int updateAnswer(Connection con, int parentgroupno, int parentgroupsq) {
		/*
		 * UPDATE ANSWERBOARD SET GROUPSQ=GROUPSQ+1
				WHERE GROUPNO=(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2)
  				AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2);
		 */
		PreparedStatement pstm = null;
		int res =0;
		
		String sql = " UPDATE ANSWERBOARD SET GROUPSQ=GROUPSQ+1 "
				+" WHERE GROUPNO=? AND GROUPSQ>? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, parentgroupno);
			pstm.setInt(2, parentgroupsq);
			System.out.println("03.query 준비 : "+sql);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}
	public int insertAnswer(Connection con, AnswerDto dto) {
		PreparedStatement pstm = null;
		int res = 0;
		//INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL,
//				(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2),
//				(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2)+1,
//				(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=2)+2,
//				'RE:두번째 글','2번글의 답변 글 두번째임','유저3',SYSDATE);

		String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL, ?,?,?,?,?,?, SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getGroupno());  //부모의 groupno
			pstm.setInt(2, dto.getGroupsq()+1);//부모의 groupsq + 1
			pstm.setInt(3, dto.getTitletab()+2); //부모의 titletab + 2
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			System.out.println("03.query 준비: "+sql);
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
		}
		return res;
	}
	public int countUpdate(Connection con, int parentgroupno, int parentgroupsq) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int res = 0;
		
		String sql = " SELECT COUNT(*) FROM ANSWERBOARD WHERE GROUPNO=? AND GROUPSQ>? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, parentgroupno);
			pstm.setInt(2, parentgroupsq);
			System.out.println("03.query 준비 : " +sql);
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			while(rs.next()) {
				res = rs.getInt(1);
			}
			System.out.println("update할 데이터 갯수: "+res);
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
		}
		return res;
	}
}
