//우선 개별적으로 카테고리 클릭하면 할일 적는 란 보이게
function maketodo1(){
  const count = 1;
  let categorydiv = document.getElementById("category1");
  let newtodo = document.createElement("div");
  newtodo.setAttribute("id","todolist");
  newtodo.innerHTML=`<span id="check" class="todo${count}">⭐</span>
  <input type=text name="todocontent" class="todo${count}" id="todo_input" placeholder="할 일 입력"  
  onchange="confirmTodo()">
  <span>📌</span>`;
  categorydiv.appendChild(newtodo);
  document.getElementById("todo_input").focus();
  let content = document.getElementById("todo_input").value;
  if(value==null||value==""){
    maketodo1();
  }
  
}

//할일 입력하고 확정시켜 입력란 대신 입력한 할일 띄우기
function confirmTodo(){
  let todoContent = document.getElementById("todo_input").value; //입력한 값 가져오기
  let confirmtodo = document.getElementById("todolist");
  confirmtodo.innerHTML = `<span id="check">⭐</span>
  <div id="c_todo_input">${todoContent}</div>
  <span>📌</span>`;
}

function pluscategory(){
  let menu = document.getElementById("plus"); 
  menu.classList.toggle("show");
}