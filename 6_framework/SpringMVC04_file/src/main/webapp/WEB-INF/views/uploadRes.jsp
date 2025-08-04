<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>업로드 완료</h1>
	<h3>파일명 : ${fileobj.filename }</h3>
	<h3>설명 : </h3>
	<textarea rows="10" cols="30" readonly="readonly">${fileobj.desc }</textarea>
</body>
</html>