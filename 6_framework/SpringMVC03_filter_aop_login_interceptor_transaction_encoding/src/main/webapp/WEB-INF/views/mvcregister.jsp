<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	<form action="register.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="memberpw"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="membername"></td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
	<!-- 해당 페이지에서 register.do라는 요청으로 서버에 회원가입요청을 보낸다.
		register.do 라는 요청을 받아 처리하는 controller의 meberInsert() 만들어
		parameter값도 잘 받아준다.
	 -->
</body>
</html>