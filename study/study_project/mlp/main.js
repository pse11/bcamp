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

function createFeed(){
  
}