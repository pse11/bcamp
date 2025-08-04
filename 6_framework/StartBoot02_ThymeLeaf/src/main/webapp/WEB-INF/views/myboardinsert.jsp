<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert</h1>
	<!-- 작성완료하였을때 해당 요청을 처리할 메소드
		db에 입력 받은 데이터 저장한ㄷ.ㅏ
		성공시 목록 페이지로
		실패시 글삭성 페이지로 이동한다. -->
	<form action="/myboard/insert" method="post">
		<table>
			<tr>
				<th>myname</th>
				<td><input type="text" name="myname"></td>
			</tr>
			<tr>
				<th>mytitle</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>mycontent</th>
				<td><textarea rows="10" cols="40" name="mycontent"></textarea></td>
			</tr>
			<tr>	
				<td colspan="2" align="right">
					<input type="submit" value="작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>