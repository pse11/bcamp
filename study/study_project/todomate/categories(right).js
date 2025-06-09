
let count=0; 
//입력창 생성 함수
function maketodo(number){
  //input태그가 존재하면 새로 만들지 않음
  let newtodo = document.createElement("div");
  newtodo.setAttribute("id","todolist");
  if(document.getElementById(`todo_input${count-1}`)){
    return;
  }else{
    let categorydiv = document.getElementById(`category${number}`);
    newtodo.innerHTML=`<span>⭐</span>
    <input type=text name="todocontent" class="todo2" id="todo_input${count}" placeholder="할 일 입력"  
    onchange="confirmTodo(${count},this.value)">
    <span>📌</span>`;
    categorydiv.appendChild(newtodo);
    document.getElementById(`todo_input${count}`).focus();
    count++;
  }
}

//할일 입력하고 확정시켜 입력란 대신 입력한 할일 띄우기
function confirmTodo(count, value){
  let confirm = document.getElementById(`todolist`);
  let valuediv = document.createElement("div");
  valuediv.setAttribute("class",`c_todolist`);
  valuediv.setAttribute("id",`cid_todolist${count}`);
  valuediv.innerHTML = `<span>⭐</span>
    <div class="c_todo_input" id="c_todo${count}">${value}</div>
    <span onclick=deletelist(${count})>📌</span>`;
  // input태그 자리에 div 태그 넣기 (gpt 참고)
  confirm.parentNode.replaceChild(valuediv,confirm);
}
//수정, 삭세 팝업 띄우기
function deletelist(icount){
  let popup = document.getElementById("deletepopup");
  let content = document.getElementById("clickcontent");
  let b_content = document.getElementById(`c_todo${icount}`).innerText;
  content.innerText = b_content;
  //요소 불러왔을 때 스타일이 none이면 block으로, block이면 none으로 변경시켜 toggle처럼 사용
  if(popup.style.display==="none"){
    popup.style.display="block";
  }else{
    popup.style.display="none";
  }
  let $delete = document.getElementById("delete");
  $delete.setAttribute("onclick",`deleteitem(${icount})`);
}
// 상단바 카테고리 등록 팝업(toggle)
function showmenu(){
  let ele = document.getElementById("sub_menus");
  //요소 불러왔을 때 스타일이 none이면 block으로, block이면 none으로 변경시켜 toggle처럼 사용
  if(ele.style.display==="none"){
    ele.style.display="block";
  }else{
    ele.style.display="none";
  }
}
//수정, 삭제 팝업띄워진 상태에서 배경 클릭하면 다시 사라지게끔 구글 참고했지만 실패
// document.addEventListener("click",function(e){
//   let popup = document.getElementById("deletepopup");
//   //popup이 열려있고 클릭한 요소가 popup 내부가 아닐때
//   if(popup.style.display==="block" && !popup.contains(e.target)){
//     popup.style.display="none";
//   }
// });

//할일 삭제하기
function deleteitem(icount){
  let popup = document.getElementById("deletepopup");
  popup.style.display="none";
  document.getElementById(`cid_todolist${icount}`).remove();
}

//카테고리 추가 등록
function regist(){
  //현재 등록되어있는 카테고리 버튼들의 개수세기
  let categorycount = document.getElementsByClassName("cateButton").length;
  categorycount++;
  let div = document.getElementById("categories");
  let item = document.createElement("div");
  //새로 추가할 버튼의 속성, html을 추가
  item.innerHTML=`
  <div id="category${categorycount}" class="cateButton">
    <span onclick="maketodo(${categorycount})")>🔒&nbsp;카테고리 ${categorycount}&nbsp;+</span>
  </div>`;
  div.appendChild(item);
}