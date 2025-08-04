<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 수정 페이지</h1>
	<form action="update.do" method="post">
		<input type="hidden" name="testno" value="${dto.testno }">
		<input type="hidden" name="testid" value="${dto.testid }">
		<table>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="testtitle" value="${dto.testtitle }"></td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td>${dto.testname }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="40" name="testcontent">${dto.testcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>