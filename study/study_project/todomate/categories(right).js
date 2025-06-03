//우선 개별적으로 카테고리 클릭하면 할일 적는 란 보이게
let count=0;
function maketodo1(){
  if(document.getElementById("todo_input")){
    return;
  }
  let categorydiv = document.getElementById("category1");
  let newtodo = document.createElement("div");
  newtodo.setAttribute("id",`todolist${count}`);
  newtodo.innerHTML=`<span id="check" class="todo">⭐</span>
  <input type=text name="todocontent" class="todo2" id="todo_input${count}" placeholder="할 일 입력"  
  onchange="confirmTodo(${count})">
  <span>📌</span>`;
  count++;
  categorydiv.appendChild(newtodo);
  document.getElementById("todo_input").focus();
  let content = document.getElementById("todo_input").value;
}

//할일 입력하고 확정시켜 입력란 대신 입력한 할일 띄우기
function confirmTodo(idx){
  alert(idx);

  let todoContent = document.getElementsByClassName("todo")[idx].value; //입력한 값 가져오기
  let confirmtodo = document.getElementById(`todolist${idx}`);
  confirmtodo.innerHTML = `<span id="check">⭐</span>
  <div class="c_todo_input">${todoContent}</div>
  <span>📌</span>`;
}

function pluscategory(){
  let menu = document.getElementById("plus"); 
  menu.classList.toggle("show");
}