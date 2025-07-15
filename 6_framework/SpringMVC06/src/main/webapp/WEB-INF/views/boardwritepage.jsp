<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 작성 페이지</h1>
	<form action="boardwrite.do" method="post">
		<input type="hidden" name="testname" value="${logindto.memname }">
		<table>
			<tr>
				<th>WRITER</th>
				<td>${logindto.memname }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="testtitle"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows="10" cols="40" name="testcontent"></textarea></td>
			</tr>
			<tr>	
				<td colspan="2">
					<input type="submit" value="작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>