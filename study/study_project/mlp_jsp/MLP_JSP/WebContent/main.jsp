<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./main.css" />
<script type="text/javascript" src="./main.js"></script>
<script>
	function replyForm(commentno,loginno){
		let div = document.getElementById("reply"+commentno);
		
		//이미 form이 있으면 중복 생성 방지
		if(document.getElementById("replyform"+commentno)){
			return;
		}
		console.log(commentno);
		console.log(loginno);
		//form 생성
		let form = document.createElement("form");
		form.id="replyform"+commentno;
		form.action="reply";
		form.method="post";
		form.innerHTML=`
			<input type="hidden" name="command" value="reply">
			<input type="hidden" name="commentno" value="${commentno}">
			<input type="hidden" name="writerno" value="${login}">
			<span>👤</span>
			<input type="text" name="replys" placeholder="답글을 입력해 주세요.">
			<input type="submit" value="등록">
		`;
		div.appendChild(form);
	}
</script>
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
                    <button onclick="location.href='member?command=logout'">로그아웃</button>
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
                <button onclick="createFeed()" id="createtext">+ 피드작성</button>
                <div id="feedSearch">
                	<form action="board" method="post" id="searchform">
                		<input type="hidden" name="command" value="search">
                    	<input type="search" name="feedsearch" placeholder="검색어를 입력해주세요.">
						<input type="submit" value="🔍">                	
                	</form>
               
                    <select id="orderby" name="orderby" onchange="location.href='board?command=boardorder&orderby='+this.value;">
                    	<!-- select된 값이 asc만 값이 넘어오는 문제 발생.  
                    	{param.orderby로 이전에 선택된 값을 가져와 selected해줌-->
                        <option value="DESC" <c:if test="${param.orderby=='DESC' }">selected</c:if>>최신순</option>
                        <option value="ASC"<c:if test="${param.orderby=='ASC' }">selected</c:if>>오래된순</option>    
                        <option value="TITLE"<c:if test="${param.orderby=='TITLE' }">selected</c:if>>제목순</option>                        
                    </select>
                    <img src="./img/1b.png" alt="1b">
                    <img src="./img/2w.png" alt="1b">
                    <img src="./img/3w.png" alt="1b">
                </div>
            </div>
            <div id="feedContent">
            	<c:choose>
            		<c:when test="${empty list }">
            			<div>작성된 글이 없습니다.</div>
            		</c:when>
            		<c:otherwise>
            			<c:forEach items="${list }" var="boarddto">
            				<div class="content">
			                    <div class="writer">
			                        <div class="wimg">👤</div>
			                        <div class="wname">
			                            <p>${boarddto.writer }</p>
			                            <p>[현대이지웰] Java 풀스택 개발자 아카데미 5회차</p>
			                        </div>
			                        <div class="updatebtn">
			                        <c:choose>
			                        	<c:when test="${dto.id eq boarddto.id }">
			                        		<a class="feedbt" href="board?command=updateform&no=${boarddto.no } " >수정</a>
			                        		<a class="feedbt" href="board?command=delete&no=${boarddto.no}" >삭제</a>
			                        	</c:when>
			                        	<c:otherwise>
			                        		<a class="feedbt" href="">신고</a>
			                        	</c:otherwise>
			                        </c:choose>
			                        </div>
			                    </div>
			                    <div class="sdate"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boarddto.regDate }"/></div>
			                    <div class="srange">${boarddto.release }</div>
			                    <div class="stitle">${boarddto.title }</div>
			                    <div class="scontent">${boarddto.content }</div>
			                    <div class="skeyword">${boarddto.keyword }</div>
			                    <div class="scomment">
			                    	<div class="inputcomment">
			                    		<span>👤</span>
			                    		<form action="comment" method="post">
			                    			<input type="hidden" name="command" value="insert">
			                    			<input type="hidden" name="id" value="${dto.id }">
			                    			<input type="hidden" name="name" value="${dto.name }">
			                    			<input type="hidden" name="boardno" value="${boarddto.no }">
				                    		<input type="text" class="insertcomment" name="content" placeholder="댓글을 입력해 주세요.">
				                    		<input type="submit" class="csubmitbtn" value="등록">
			                    		</form>
			                    	</div>
	                    			<c:set var="commentCount" value="0"/>
			                    	<c:forEach items="${clist}" var="commentdto">
			                    		<c:if test="${commentdto.boardno eq boarddto.no }">
			                    			<c:set var="commentCount" value="${commentCount+1 }"/>
			                    		</c:if>
			                    	</c:forEach>
			                    	<div class="showcomment">
		                    			<div class="countcomment">
			                    			<p>📨</p>
			                    			<p>댓글 ${commentCount}</p>
			                    		</div>
				                    	<div class="commentlist">
			                    			<c:forEach items="${clist }" var="commentdto">
			                    				<c:if test="${boarddto.no eq commentdto.boardno }">
				                    				<div class="commentone">
			                    						<span>👤</span>
			                    						<div class="commentwriter">
			                    							<span><b>${commentdto.name }</b></span>
			                    							<span><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${commentdto.cdate }"/></span>
			                    							<p>${commentdto.content }</p>
			                    						</div>
			                    						<div class="cupdate">
			                    						<a class="feedbt" onclick="replyForm('${commentdto.no }','${dto.no }')">답글</a>
								                        <c:choose>
								                        	<c:when test="${dto.id eq commentdto.id }">
								                        		<a class="feedbt" href="comment?command=updateform&no=${commentdto.no }&content=${commentdto.content}" >수정</a>
								                        		<a class="feedbt" href="comment?command=delete&no=${commentdto.no}" >삭제</a>
								                        	</c:when>
								                        	<c:otherwise>
								                        		<a class="feedbt" href="">신고</a>
								                        	</c:otherwise>
								                        </c:choose>
								                        </div>
			                    					</div>
			                    					<div class="reply" id="reply${commentdto.no }"></div>
			                    				</c:if>
			                    			</c:forEach>
				                    	</div>
					                 </div>
					              </div>
			    	           </div>
			             </c:forEach>
		             </c:otherwise>
	             </c:choose>
             </div>
          </div>
    </div>
    <div id="rightbtns">
        <div id="bookmark" onclick="location.href='board?command=bookmark'">
            <img src="./img/bookmark.png" alt="bookmark">
        </div>
        <div id="toTop" onclick="movetoTop();">
            <span>^</span><br>
            <span>TOP</span>
        </div>
    </div>
    <div id="createFeed">
        <form action="board" method="post">
        	<input type="hidden" name="command" value="createfeed">
        	<input type="hidden" name="writer" value="${dto.name }">
        	<input type="hidden" name="id" value="${dto.id }">
            <input id="ititle" type="text" name="title" placeholder="제목을 입력해주세요.">
            <input id="ikey" type="text" name="keyword" placeholder="키워드를 입력해 주세요.(엔터로 여러 키워드 등록 가능)">
            <textarea name="content" placeholder="타인의 저작물을 무단 인용하는 경우 저작권 침해에 해당할 수 있으니, 저작권 준수를 부탁드립니다."></textarea>
            <div id="btns"><span>🖼️</span><span>📎</span><span>▶️</span></div>
            <div id="feedsubmit">
                <select name="release" id="range">
                    <option name="release"  value="팔로워공개">팔로워공개</option>
                    <option name="release"  value="사용자 지정 공개">사용자 지정 공개</option>
                    <option name="release"  value="비공개">비공개</option>
                    <option name="release"  value="우리회사 공개">우리회사 공개</option>
                </select>
                <div id="rbtns">
                    <input type="button" value="취소" onclick="cancel();">
                    <input type="submit" value="등록" onclick="cancel();">
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
    <!-- 수정 팝업 -->
    
</body>
</html>