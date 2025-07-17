<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./main.css" />
<link type="text/css" rel="stylesheet" href="./update.css" />
</head>
<body>
	<div id="updateFeed">
        <form action="board" method="post">
        	<input type="hidden" name="command" value="updatefeed">
        	<input type="hidden" name="no" value="${dto.no}">
            <input id="ititle" type="text" name="title" value="${dto.title }" placeholder="제목을 입력해주세요.">
            <input id="ikey" type="text" name="keyword" value="${dto.keyword }" placeholder="키워드를 입력해 주세요.(엔터로 여러 키워드 등록 가능)">
            <textarea name="content" placeholder="타인의 저작물을 무단 인용하는 경우 저작권 침해에 해당할 수 있으니, 저작권 준수를 부탁드립니다.">${dto.content }</textarea>
            <div id="btns"><span>🖼️</span><span>📎</span><span>▶️</span></div>
            <div id="feedsubmit">
                <select name="release" id="range">
                    <option name="release"  value="팔로워공개">팔로워공개</option>
                    <option name="release"  value="사용자 지정 공개">사용자 지정 공개</option>
                    <option name="release"  value="비공개">비공개</option>
                    <option name="release"  value="우리회사 공개">우리회사 공개</option>
                </select>
                <div id="rbtns">
                    <input type="button" value="취소" onclick="history.back()">
                    <input type="submit" value="수정">
                </div>
            </div>
        </form>
    </div>
</body>
</html>