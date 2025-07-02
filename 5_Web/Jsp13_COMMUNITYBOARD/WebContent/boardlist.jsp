<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		document.getElementById("muldelchk").addEventListener("submit",function(e){
			let checked = document.querySelectorAll("#muldelchk input:checked");
			if(checked.length==0){
				alert("하나 이상 체크해 주세요");
				e.preventDefault();
			}
		});
	}
</script>
</head>
<body>
	<div>
		${memberdto.name }님
		<input type="button" value="마이페이지" onclick="location.href='board?command=mypage&no=${memberdto.no}'">
		<input type="button" value="로그아웃" onclick="location.href='board?command=logout'">
	</div>
	<h1>게시판 목록</h1>
	<form action="board" method="post" id="muldelchk">
		<input type="hidden" name="command" value="muldel">
		<table>
			<tr>
				<th>&nbsp;</th>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4">----작성된 글이 존재하지 않습니다.----</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${list }">
					<tr>
						<td><input type="checkbox" name="chk" value="${dto.no }">
						<td>${dto.no }</td>
						<td><a href="board?command=boarddetail&no=${dto.no }">${dto.title }</a></td>
						<td>${dto.name }</td>
						<td><fmt:formatDate value="${dto.regdate }" pattern="yy년MM월dd일"/></td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="4">
					<input type="button" value="글쓰기" onclick="location.href='board?command=boardwriteform'">
					<input type="submit" value="삭제">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>