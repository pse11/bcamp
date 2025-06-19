<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.board.dto.BoardDto" %>
<%@ page import="com.board.dao.BoardDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	//form에 submit이벤트 발생하면, input태그 체크하여 입력하지 않은 태그가 있다면 submit취소
	$(function(){
		$("form").submit(function(){
			if($("form input:text").val()==""||$("textarea").val()==""){
				alert("모두 입력해주세요");
				return false; //기본 이벤트 취소
			}
		});
	});
	/*document.getElementsByTagName("form")[0].addEvendListener("submit",function(){
		
	});*/
</script>
</head>
<body>
	<!-- 새로운 게시글을 입력받아 data를 전달 -->
	<h1>Write</h1>
	<form action="boardwrite_res.jsp" method="post">
		<table>
			<tr>
				<th>WRITER</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="40" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성완료">
					<input type="button" value="취소" onclick="location.href='boardlist.jsp'">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>