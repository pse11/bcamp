<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.my2.dto.MyBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MyBoardDto dto = (MyBoardDto)request.getAttribute("dto");
%>
<h1>Update</h1>
<form action="mycontroller.jsp" method="post">
	<input type="hidden" name="command" value="myupdate">
	<input type="hidden" name="no" value="<%=dto.getMyno() %>">
	<table>
		<tr>
			<th>NAME</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><input type="text" value="<%=dto.getMytitle() %>" name="title"></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" name="content"><%=dto.getMycontent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="button" value="취소" onclick="history.back();">
			</td>
		</tr>
	</table>
</form>
</body>
</html>