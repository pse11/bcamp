
// window.onload=function(){
//   let $div = document.getElementById("categories");
//   let replacediv = document.getElementById("content");
//   replacediv.parentNode.replaceChild($div,replacediv);
// } 
let count2;
function plus(){
    count2 = document.querySelectorAll("#m_categories > div").length;
   let shownew = document.getElementById("n_details");
   shownew.style.display="block";
   document.getElementById("newcateinput").value="";
}


function details(idx){
    count2 = idx;
    //let ordiv = document.getElementById("ori");
    let showdetail = document.getElementById("m_details");
    //ordiv.parentNode.replaceChild(showdetail,ordiv);
    document.getElementById("cateinput").focus();
    let content = document.getElementById(`t_cate${idx}`).innerText;
    showdetail.style.display="block";
    let input = document.getElementById("cateinput");
    input.value=content;
}

function hide_detail(){
    let hidedetail=document.getElementById("m_details");
    let hidedetail2=document.getElementById("n_details");
    hidedetail.style.display="none";
    hidedetail2.style.display="none";
}
//카테 제목 수정
function confirm_detail(){
    let input = document.getElementById("cateinput").value;
    let changecate = document.getElementById(`t_cate${count2}`);
    changecate.innerText=input;
    hide_detail();
}
//카테 등록
function n_confirm_detail(){
    count2++;
    let $div = document.getElementById("m_categories");
    let newdiv = document.createElement("div");
    let input = document.getElementById("newcateinput").value;
    newdiv.setAttribute("id",`cate${count2}`);
    newdiv.setAttribute("class","cateButton");
    newdiv.setAttribute("onclick",`details(${count2})`);
    newdiv.innerHTML = `<span id="t_cate${count2}">${input}</span>`
    $div.appendChild(newdiv);
    hide_detail();
}

function delete_cate(){
    let changecate = document.getElementById(`t_cate${count2}`);
    changecate.remove();
    hide_detail();
}