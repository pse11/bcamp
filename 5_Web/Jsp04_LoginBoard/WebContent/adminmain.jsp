<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.login.dto.MyMemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//session에 있는 dto 꺼내오기
	MyMemberDto dto = (MyMemberDto)session.getAttribute("dto");
	if(dto==null){//세션이 비어있음-> 로그인하게끔 index페이지로 이동
		pageContext.forward("index.jsp");
	}
%>
	<div>
		<span><%=dto.getMyname() %> 님 환영합니다.(등급: <%=dto.getMyrole() %>)</span>
		<button onclick="location.href='logincontroller.jsp?command=logout'">logout</button>
	</div>
	<h1>Admin Main</h1>
	<div>
		<div>
			<h3><a href="logincontroller.jsp?command=userlistall">회원정보 조회(All)</a></h3>
		</div>
	</div>
</body>
</html>