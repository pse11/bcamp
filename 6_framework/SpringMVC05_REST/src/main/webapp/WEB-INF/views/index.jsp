<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	
	<!-- get방식(a 태그니까) -->
	<h3><a href="restdto">1.selectList</a></h3>
	<!-- 1번게시글 가져오고 싶다. -->
	<h3><a href="restdto/1">2.selectOne</a></h3>
	<hr>
	<!-- post 방식 -->
	<form action="restdto" method="post">
		ID:<input type="text" name="restid"><br>
		PW:<input type="text" name="restpw"><br>
		NAME:<input type="text" name="restname"><br>
		<input type="submit" value="insert">
	</form>
	
	<!-- delete -->
	<form action="restdto/1" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="delete">
	</form>	
	
	<!-- put -->
	<!-- put method로 요청을 보내 2번 게시글의 pw값을 db에서 수정하자. -->
	<!-- HiddenHttpMethodFilter는 POST 요청에서만 _method 를 읽고 PUT, DELETE로 변환 -->
	<form action="restdto" method="post">
		<input type="hidden" name="_method" value="put">
		<input type="hidden" name="restno" value="2">
		변경할 비밀번호 : <input type="text" name="restpw"><br>
		<input type="submit" value="update">
	</form>
</body>
</html>