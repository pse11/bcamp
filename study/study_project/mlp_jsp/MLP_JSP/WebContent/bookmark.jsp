<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./main.css" />
</head>
<body>
	<div id="header">
		<div id="topmenu">
			<div id="logo">
				<h1><a href="board?command=showfeeds">MLP</a></h1>
			</div>
			<div id="search">
				<input type="search" name="search"
					placeholder="관심있는 주제, 키워드로 검색해보세요.">
			</div>
			<div id="icons">
				<span>➕</span> <span>🔔</span> <span>👤</span>
			</div>
		</div>
		<div id="menubar">
			<ul class="nav_menu">
				<li><a href="">=&nbsp;&nbsp;카테고리</a></li>
				<li><a href="">피드</a></li>
				<li><a href="">지식콘텐츠</a></li>
				<li><a href="">캠퍼스</a></li>
				<li><a href="">나의학습</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div id="ctitle">
			<h1>찜 목록</h1>
			<p>찜한 과정과 콘텐츠를 통해 학습을 이어가세요. (폐강 과정은 과정 목록에서 제외됩니다.)</p>
		</div>
		<div id="cmenu"></div>
		<div id="csearchbar"></div>
		<div id="ccontent"></div>
	</div>
</body>
</html>