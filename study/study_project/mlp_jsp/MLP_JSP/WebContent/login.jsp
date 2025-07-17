<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./login.css" />
</head>
<body>
	<div id="wrapper"> 
    <div id=content>
      <div id="logo">
          <img src="./img/logo2.png" id="imglogo">
      </div>
      <div id="insertIdPw">
      	<form action="member" method="post">
          <input type="hidden" name="command" value="login">
          <input type="text" name="id" placeholder="아이디를 입력해 주세요.">
          <input type="password" name="pw" placeholder="비밀번호를 입력해 주세요.">
          <input type="submit" value="로그인" id="submitbtn">
        </form>
        <button id="registbtn" onclick="location.href='member?command=registform'">회원가입</button>
      </div>
    </div> 
  </div>
</body>
</html>