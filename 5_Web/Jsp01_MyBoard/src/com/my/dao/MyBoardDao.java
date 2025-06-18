package com.my.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.MyBoard;
public class MyBoardDao { //db에 접속하는 클래스
	//db에 저장된 데이터를 다 모아와서 list에 저장한 후 반환
	//전체출력
	public List<MyBoard> selectAll(){
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MyBoard> res = new ArrayList<>();
		String sql = " SELECT * FROM MYBOARD ORDER BY MYNO DESC";
		try {
			stmt = con.createStatement();
			System.out.println("03.query 준비: "+ sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("04.query 실행 및 리턴");
			
			while(rs.next()) {
				MyBoard dto = new MyBoard(rs.getInt(1),rs.getString(2),rs.getString(3),
								rs.getString(4),rs.getDate(5));
				res.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
			System.out.println("05. db종료");
		}
		return res;
	}
	
	//글작성
	public int insert(MyBoard dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO MYBOARD VALUES(SEQ_MYBOARD.NEXTVAL, ?,?,?,SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyname());
			pstm.setString(2, dto.getMytitle());
			pstm.setString(3, dto.getMycontent());
			System.out.println("03.query 준비: "+sql);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료");
		}
		return res;
	}
	
	//선택출력
	public MyBoard selectOne(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs= null;
		MyBoard res = null; //만약 조회후 dto가 null이면 데이터 조회된게 없다는 의미
		String sql = " SELECT * FROM MYBOARD WHERE MYNO=? ";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03.query 준비 : "+sql);
			rs = pstm.executeQuery();
			System.out.println("04.query 실행 및 리턴");
			if(rs.next()) {
				res = new MyBoard(rs.getInt(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05.db 종료\n");
		}
		return res;
	}
	
	//수정
	public int update(MyBoard dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MYBOARD SET MYTITLE=?,MYCONTENT=? "
				+" WHERE MYNO=? "; //나눠서 작성할땐 앞뒤에 공백 필수
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMytitle());
			pstm.setString(2, dto.getMycontent());
			pstm.setInt(3, dto.getMyno());
			System.out.println("03.query 준비: "+ sql);
			
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료\n");
		}
		return res;
	}
	
	//삭제
	public int delete(int myno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM MYBOARD WHERE MYNO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("03.query 준비: "+sql);
			res = pstm.executeUpdate();
			System.out.println("04.query 실행 및 리턴");
			if(res>0) {
				commit(con);
			}else {
				rollback(con);
			}
		} catch (SQLException e) {
			System.out.println("3/4단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05.db 종료\n");
		}
		
		return res;
	}
}
