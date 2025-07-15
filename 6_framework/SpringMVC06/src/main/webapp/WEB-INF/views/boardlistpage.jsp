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
	<h1>게시판 페이지</h1>
	<table>
		<colgroup>
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="100">
		</colgroup>
		<tr>
			<th>NO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>DATE</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>	
					<td colspan="4">-----작성된 글이 없습니다.-----</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>	
						<td>${dto.testno }</td>
						<td><a href="detail.do?testno=${dto.testno }">${dto.testtitle }</a></td>
						<td>${dto.testname }</td>
						<td>${dto.testdate }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="4">
				<input type="button" value="글쓰기" onclick="location.href='writeform.do'">
			</td>
		</tr>	
	</table>
</body>
</html>