<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./login.css">
</head>
<body>
<div id="wrapper"> 
    <div id=content>
      <div id="logo">
          <img src="./img/logo2.png" id="imglogo">
      </div>
      <div id="insertinfo">
      	<form action="member" method="post">
          <input type="hidden" name="command" value="regist">
          <input type="text" name="name" placeholder="이름을 입력해 주세요.">
          <input type="text" name="id" placeholder="아이디를 입력해 주세요.">
          <input type="password" name="pw" placeholder="비밀번호를 입력해 주세요.">
          <input type="email" name="email" placeholder="이메일을 입력해주세요.">
          <input type="text" name="phone" placeholder="전화번호를 입력해주세요.">
          <input type="text" name="dept" placeholder="소속부서를 입력해주세요.">
          <input type="submit" value="가입" id="submitbtn">
        </form>
      </div>
    </div> 
  </div>
</body>
</html>