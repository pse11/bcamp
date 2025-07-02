<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./main.css" />
<script type="text/javascript" src="./main.js"></script>

</head>
<body>
	<div id="header">
        <div id="topmenu">
            <div id="logo" onclick="movetoTop()"><h1>MLP</h1></div>
            <div id="search"><input type="search" name="search" placeholder="관심있는 주제, 키워드로 검색해보세요."></div>
            <div id="icons">
                <span>➕</span>
                <span>🔔</span>
                <span>👤</span>
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
        <div id="leftContent">
            <div id="profile">
                <div id="ptop">
                    <div id="pimg">👤</div>
                    <div id="pname">
                        <h3>${dto.name }</h3>
                        <p>${dto.dept }</p>
                       	<p id="info">${dto.info }</p>
                    </div>
                </div>
                <div id="pbottom">
                    <p>팔로워 0 | 팔로잉 0</p>
                    <span>☺️👻</span>
                    <button onclick="openeditprofile()">프로필 수정</button>
                </div>
            </div>
            <div id="feed">
                <ul>
                    <li>전체 피드</li>
                    <li>📢알려드립니다!</li>
                    <li>우리회사 피드</li>
                    <li>팔로잉 피드</li>
                    <li>캠퍼스 피드</li>
                    <li>내가 작성한 피드</li>
                    <li>저장한 피드</li>
                </ul>
            </div>
            <div id="recommend">
                <div id="rtop">
                    <span><b>친구 추천</b></span>
                    <span class="right">&gt;</span>
                    <span class="right">&lt; </span>
                    
                </div>
                <div id="rbottom">
                    <div class="rfriend"></div>
                    <div class="rfriend"></div>
                </div>
            </div>
        </div>
        <div id="rightContent">
            <div id="feedheader">
                <span><b>전체 피드</b></span>
                <button onclick="createFeed()">+ 피드작성</button>
                <div id="feedSearch">
                    <input type="search" name="feedsearch" placeholder="검색어를 입력해주세요.">
                    <select name="orderby">
                        <option value="recent">최신순</option>
                        <option value="check">조회순</option>
                        <option value="like">좋아요순</option>
                        <option value="comment">댓글순</option>
                    </select>
                    <img src="./img/1b.png" alt="1b">
                    <img src="./img/2w.png" alt="1b">
                    <img src="./img/3w.png" alt="1b">
                </div>
            </div>
            <div id="feedContent">
                <div class="content">
                    <div id="writer">
                        <div id="wimg">👤</div>
                        <div id="wname">
                            <p>박상은</p>
                            <p>[현대이지웰] Java 풀스택 개발자 아카데미 5회차</p>
                        </div>
                    </div>
                    <div id="srange">비공개</div>
                    <div id="stitle">제목</div>
                    <div id="scontent">내용</div>
                    <div id="skeyword">키워드</div>
                </div>
                <img id="3" src="./img/feed.png" alt="feed">
                <img id="2" src="./img/feed.png" alt="feed">
                <img id="1" src="./img/feed.png" alt="feed">
            </div>
        </div>
    </div>
    <div id="rightbtns">
        <div id="bookmark" onclick="location.href='bookmark.html'">
            <img src="./img/bookmark.png" alt="bookmark">
        </div>
        <div id="toTop" onclick="movetoTop();">
            <span>^</span><br>
            <span>TOP</span>
        </div>
    </div>
    <div id="createFeed">
        <form id="feedform">
            <input id="ititle" type="text" name="title" placeholder="제목을 입력해주세요.">
            <input id="ikey" type="text" name="keyword" placeholder="키워드를 입력해 주세요.(엔터로 여러 키워드 등록 가능)">
            <textarea name="content" placeholder="타인의 저작물을 무단 인용하는 경우 저작권 침해에 해당할 수 있으니, 저작권 준수를 부탁드립니다."></textarea>
            <div id="btns"><span>🖼️</span><span>📎</span><span>▶️</span></div>
            <div id="feedsubmit">
                <select id="range">
                    <option name="range"  value="팔로워공개">팔로워공개</option>
                    <option name="range"  value="사용자 지정 공개">사용자 지정 공개</option>
                    <option name="range"  value="비공개">비공개</option>
                    <option name="range"  value="우리회사 공개">우리회사 공개</option>
                </select>
                <div id="rbtns">
                    <input type="button" value="취소" onclick="cancel();">
                    <input type="button" value="등록" onclick="fsubmit();">
                </div>
            </div>
        </form>
    </div>
    <div id="correctprofile">
        <form action="member" method="post">
        	<input type="hidden" name="command" value="updateprofile">
        	<input type="hidden" name="no" value="${dto.no }">
            <div id="profileheader">
                <b>프로필 수정</b>
            </div>
            <div id="profilemiddle">
                <div id="profiledetail">
                    <div id="profileimg">👤</div>
                    <div id="profilename">
                        <span>${dto.name }</span><br>
                        <input type="text" placeholder="소개글을 입력하세요." name="infomsg" class="input" value="${dto.info }"><br>
                        <input type="button" value="추천 키워드">
                    </div>
                </div>
                <div id="profilecontent">
                    <table>
                        <col width="100"><col width="400">
                        <tr>
                            <th>부서</th>
                            <td>${dto.dept }</td>
                        </tr>
                        <tr>
                            <th>이메일주소</th>
                            <td><input type="text"  class="input" name="email" value="${dto.email }"></td> 
                        </tr>
                        <tr>
                            <th>전화번호</th>
                            <td><input type="text"  class="input" name="phone" value="${dto.phone }"></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div id="profilefooter">
                <input type="button" value="취소" onclick="hide_profile()">
                <input type="submit" value="수정">
            </div>
        </form>
    </div>
</body>
</html>