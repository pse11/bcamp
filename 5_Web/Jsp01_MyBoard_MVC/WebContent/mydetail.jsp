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
	<h1>Select one Page</h1>
	<table>
		<tr>
			<th>NAME</th>
			<td><%= dto.getMyname() %> </td>
		</tr>
		<tr>	
			<th>TITLE</th>
			<td><%=dto.getMytitle() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getMycontent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="3">
				<button onclick="location.href='mycontroller.jsp?command=myupdateform&no=<%=dto.getMyno()%>'">수정</button>
				<button onclick="boardDel();">삭제</button>
				<button onclick="location.href='mycontroller.jsp?command=mylist'">목록</button>
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
		function boardDel(){
	
			if(window.confirm("삭제하시겠습니까?")){
				location.href='mycontroller.jsp?command=mydelete&no=<%=dto.getMyno()%>';
			}
			
		}
	</script>
</body>
</html>