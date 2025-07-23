<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="comment" method="post">
		<input type="hidden" name="command" value="update">
		<input type="hidden" name="no" value="${no }">
		<input type="text" name="content" value="${content }" placeholder="댓글을 입력해 주세요">
		<input type="submit" value="등록">
	</form>
</body>
</html>