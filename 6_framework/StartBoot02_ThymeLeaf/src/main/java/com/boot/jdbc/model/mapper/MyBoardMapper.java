package com.boot.jdbc.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.jdbc.model.dto.MyDto;

@Mapper
public interface MyBoardMapper {
	//mapper 
	//인터페이스이기 때문에 추상메소드, 상수만 가능
	
	@Select(" SELECT * FROM MYBOARD ORDER BY MYNO DESC ")
	List<MyDto> selectList();
	
	@Select(" SELECT * FROM MYBOARD WHERE MYNO=#{myno} ")
	MyDto selectOne(int myno);
	
	@Insert(" INSERT INTO MYBOARD VALUES(SEQ_MY.NEXTVAL, #{myname}, #{mytitle},#{mycontent},SYSDATE) ")
	int insert(MyDto dto);
	
	@Update(" UPDATE MYBOARD SET MYTITLE=#{mytitle}, MYCONTENT=#{mycontent} WHERE MYNO=#{myno}")
	int update(MyDto dto);
	
	@Delete(" DELETE FROM MYBOARD WHERE MYNO=#{myno} ")
	int delete(int myno);
			
}
