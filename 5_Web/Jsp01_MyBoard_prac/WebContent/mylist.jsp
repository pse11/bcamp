<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoardDto" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectAll();
%>
</head>

<body>
	<h1>LIST PAGE</h1>
	
	<table border="1">
		<col width="50"><col width="100"><col width="200"><col width="200">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
<%
		for(int i=0;i<list.size();i++){
%>
			<tr>
				<td><%=list.get(i).getMyno() %></td>
				<td><%=list.get(i).getMyname()%></td>
				<td><a href="mydetail.jsp?myno=<%=list.get(i).getMyno()%>"><%=list.get(i).getMytitle() %></a></td>
				<td><%=list.get(i).getMydate() %></td>
				<td><button onclick="location.href='myupdate.jsp?myno=<%=list.get(i).getMyno() %>'">수정</button></td>
				<td><button onclick="location.href='mydelete.jsp?myno=<%=list.get(i).getMyno() %>'">삭제</button></td>
			</tr>
<%
		}
%>
		<tr>
			<td colspan="4">
				<input type="button" value="글쓰기" onclick="location.href='mywrite.jsp'">
			</td>	
		</tr>
	</table>
</body>
</html>