<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="member" method="post">
		<input type="hidden" name="command" value="login">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" placehold="아이디를 입력하세요"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" placehold="비밀번호를 입력하세요"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="location.href='member?command=registform'">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>