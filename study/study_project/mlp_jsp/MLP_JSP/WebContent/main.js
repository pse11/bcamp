//top 클릭시 페이지 맨위로 이동하는 함수
function movetoTop(){
  window.scrollTo({
    top:0,
    behavior: "smooth"
  });
  let leftscroll = document.getElementById("leftContent");
  let rightscroll = document.getElementById("rightContent");
  leftscroll.scrollTo({
    top:0,
    behavior: "smooth"
  });
  rightscroll.scrollTo({
    top:0,
    behavior: "smooth"
  });
}
function openeditprofile(){
	let doc = document.getElementById("correctprofile");
	doc.style.display="block";
}
function hide_profile(){
	let doc = document.getElementById("correctprofile");
	doc.style.display="none";
}
function createFeed(){
  document.getElementById("createFeed").style.display="block";
  document.body.style.background="gray";
  document.getElementById("createtext").textContent="작성중";

}
function updateFeed(no){
		document.getElementById("updateFeed").style.display="block";
		document.getElementById("createtext").textContent="수정중";
		location.href="board?command=updateform&boardno="+no;
}
function cancel(){
  document.getElementById("createFeed").style.display="none";
  document.getElementById("createtext").textContent="+ 피드작성";
}

function getFeedParam(){
	let writer = "writer="+encodeURIComponent(document.getElementsByName("writer")[0].value);
	let title = "title="+encodeURIComponent(document.getElementById("ititle").value);
	let keyword ="keyword="+encodeURIComponent(document.getElementById("ikey").value);
	let content = "content="+encodeURIComponent(document.getElementsByName("content")[0].value);
	let release = "release="+encodeURIComponent(document.getElementById("range").value);
	
	return "?"+writer+"&"+title+"&"+keyword+"&"+content+"&"+release;
}
/*
window.onload=()=>{
	document.getElementById("feedform").addEventListener("submit",async(e)=>{
		e.preventDefault();
		try{
			const response = await fetch("Board"+getFeedParam());
			
			const boarddto = await response.json();
			
			document.getElementById("createFeed").style.display="none";
			addFeedToPage(boarddto.writer,boarddto.title,boarddto.content,boarddto.keyword,boarddto.release);
		}catch(error){
			alert("피드 작성 실패!");
		}
	});
}
*/
function addFeedToPage(){
  let feeddiv = document.getElementById("feedContent");
  let icontent = document.createElement("div");
  let writer = document.getElementsByName("writer")[0].value;
	let title = document.getElementById("ititle").value;
	let keyword =document.getElementById("ikey").value;
	let content = document.getElementsByName("content")[0].value;
	let release = document.getElementById("range").value;
  icontent.setAttribute("class","content");
  icontent.innerHTML=`<div id="writer">
                        <div id="wimg">👤</div>
                        <div id="wname">
                            <p>${writer}</p>
                            <p>[현대이지웰] Java 풀스택 개발자 아카데미 5회차 . K-디지털</p>
                        </div>
                    </div>
                    <div id="srange">${release}</div>
                    <div id="stitle">${title}</div>
                    <div id="scontent">${content}</div>
                    <div id="skeyword">${keyword}</div>`
  feeddiv.prepend(icontent);

}






