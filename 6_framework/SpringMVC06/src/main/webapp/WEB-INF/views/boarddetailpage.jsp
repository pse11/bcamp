<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<th>TITLE</th>
			<td>${dto.testtitle}</td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td>${dto.testname }</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="40" readonly="readonly">${dto.testcontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="수정" onclick="location.href='updateform.do?testno=${dto.testno}'">
				<input type="button" value="삭제" onclick="location.href='delete.do?testno=${dto.testno}'">
			</td>
		</tr>
		<c:if test="${check }">
			<script>
				alert("작성자 본인만 수정/삭제할 수 있습니다.");
			</script>
		</c:if>
	</table>
</body>
</html>