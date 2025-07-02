<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세 페이지</h1>
	<table>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="30" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='board?command=updateform&no=${dto.no}'">
				<input type="button" value="삭제" onclick="location.href='board?command=delete&no=${dto.no}'">
			</td>
		</tr>
	</table>
</body>
</html>