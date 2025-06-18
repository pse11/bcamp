<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%int no = 123; %>
	<h1>Bye.jsp...<%=no %></h1>
	<%
	for(int i=0;i<5;i++){
	%>
		<h3>반복 합시다</h3>
	<%
	}
	%>
	<hr>
	<%
	if(10>5){
	%>
		<h1>if문 조건이 true</h1>
	<%
	}
	%>
	
</body>
</html>