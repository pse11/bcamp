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

}

function cancel(){
  document.getElementById("createFeed").style.display="none";
}

function fsubmit(){
  let form = document.getElementById("feedform");
  let title = form.title.value;
  let keyword = form.keyword.value;
  let content = form.content.value;
  let range = form.range.value;
  let feeddiv = document.getElementById("feedContent");
  let icontent = document.createElement("div");
  icontent.setAttribute("class","content");
  icontent.innerHTML=`<div id="writer">
                        <div id="wimg">👤</div>
                        <div id="wname">
                            <p>박상은</p>
                            <p>[현대이지웰] Java 풀스택 개발자 아카데미 5회차 . K-디지털</p>
                        </div>
                    </div>
                    <div id="srange">${range}</div>
                    <div id="stitle">${title}</div>
                    <div id="scontent">${content}</div>
                    <div id="skeyword">${keyword}</div>`
  feeddiv.prepend(icontent);
  document.getElementById("createFeed").style.display="none";
}






