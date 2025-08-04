<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" value="게시글 목록" onclick="location.href='board?command=login'"> 
	<h1>마이페이지</h1>
	<table>
		<tr>
			<th>이름</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${dto.pw }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${dto.phone }</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="회원정보수정" onclick="location.href='member?command=updateform&no=${dto.no}'">
				<input type="button" value="탈퇴" onclick="location.href='member?command=unenable&no=${dto.no}'">
			</td>
		</tr>
	</table>
</body>
</html>