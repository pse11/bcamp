<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//controller에 담겨있는 데이터 꺼내오기 (request.setAttribute에 담겨있는 데이터)
	List<MVCBoardDto> list = (List<MVCBoardDto>)request.getAttribute("allList");
	
%>
	<h1>List</h1>
	<table>
		<col width="50px"><col width="100px"><col width="300px"><col width="100px">
		<tr>
			<th>NO</th>
			<th>WRITER</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>
<%
	if(list.size( )==0){
%>
		<tr>
			<td colspan="4">----작성된 글이 없습니다----</td>
		</tr>
<%	
	}else{
		for(MVCBoardDto dto : list){
%>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="mycontroller.jsp?command=boarddetail&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%
		}
	}
%>
	<tr>
		<td colspan="4">
			<input type="button" value="글쓰기"
				onclick="location.href='mycontroller.jsp?command=boardinsertform'">
		</td>
	</tr>
	</table>
</body>
</html>