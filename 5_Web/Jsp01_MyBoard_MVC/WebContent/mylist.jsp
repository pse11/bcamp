<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="java.util.List" %>
<%@ page import="com.my2.dto.MyBoardDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<MyBoardDto> list = (List<MyBoardDto>)request.getAttribute("allList");
%>
	<h1>List</h1>
	<table border="1">
		<col width="50px"><col width="100px"><col width="300px"><col width="100px">
		<tr>
			<th>NO</th>
			<th>WRITER</th>
			<th>TITLE</th>
			<th>DATE</th>
			<th>수정</th>
			<th>삭제</th>		
		</tr>
<%
		if(list.size()==0){
%>			
			<tr>
				<td colspan="6">----작성된 글이 없습니다----</td>
			</tr>
<%
		}else{
			for(MyBoardDto dto : list){
%>
				<tr>
					<td><%=dto.getMyno() %></td>
					<td><%=dto.getMyname() %></td>
					<td><a href="mycontroller.jsp?command=mydetail&no=<%=dto.getMyno()%>"><%=dto.getMytitle() %></a></td>
					<td><%=dto.getMydate() %></td>
					<td><input type="button" value="수정"
							onclick="location.href='mycontroller.jsp?command=myupdateform&no=<%=dto.getMyno()%>'"></td>
					<td><input type="button" value="삭제" 
							onclick="location.href='mycontroller.jsp?command=mydelete&no=<%=dto.getMyno()%>'"></td>
				</tr>
<%
			}
		}
%>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글쓰기"
						onclick="location.href='mycontroller.jsp?command=myinsertform'">
			</td>
		</tr>
	</table>
</body>
</html>