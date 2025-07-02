<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 작성 페이지</h1>
	<form action="board" method="post">
		<input type="hidden" name="command" value="boardwrite">
		<input type="hidden" name="name" value="${dto.name}">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.name }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="40" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>