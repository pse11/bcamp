let now = new Date();
  let nowMonth= now.getMonth();
  let nowYear= now.getFullYear();
  let dayOfWeek;
  let lastDate;
  let nowDate= now.getDate();
  let firstDate;
  let colorIdx=0;
    window.onload=function(){ //페이지 로드될때 달력 불러와야됨
      createDate();
     // console.log(firstDate);
      clicktable();
      
    };
    
    function clicktable(){  //달력 클릭했을 때 색 변하는 코드
        resetColor();
        let tds = document.querySelectorAll("#calander td");
        let $changecolor=document.querySelectorAll(".changecolor");
        for(let i=0;i<$changecolor.length;i++){
          $changecolor[i].style.backgroundColor="black";
        }
        console.log(colorIdx);
        tds.forEach(function(el,i){
            el.addEventListener('click',(e)=>{
            
              console.log(typeof(e.target));
              //클릭한 요소
              colorIdx=i;
              el.querySelector(".changecolor").style.backgroundColor="white";
              el.querySelector(".changecolor").style.borderRadius="50%";
              el.querySelector(".changecolor").style.color="black";
        })
      })
    }
    function resetColor(){
      let spans = document.querySelectorAll("#calander span");
      let $color = document.getElementsByClassName("changecolor");
      console.log($color.length);
      for(let i=0;i<$color.length;i++){
        $color[i].style.backgroundColor="black";
        //console.log(document.querySelector(`.changecolor:nth-child(${i})`));
        //document.querySelector(`.changecolor:nth-child(${i})`).style.backgroundColor="black";
      }
      
    }
    function createDate(nowMonth=now.getMonth(),nowYear=now.getFullYear()){  //각종 날짜 구하기 코드
      //date객체로 년 월 가져오기
      //해당 월의 1일이 무슨 요일인지 확인
      //그달이 며칠까지 있는지 계산
      // 그 시작 요일부터 1일 넣기
       //현재 날짜 구하기
      firstDate = new Date(nowYear,nowMonth,1); //1일인 날짜 반환
      dayOfWeek = firstDate.getDay();// 일:0, ...토:6
      lastDate = new Date(nowYear,nowMonth+1,0).getDate();
      let doc = document.getElementById("data_content");
      let content = createTable(dayOfWeek,lastDate);
      console.log(nowDate);
      clicktable();
      let date = document.getElementById("date");
      date.textContent=`${nowYear}년 ${nowMonth+1}월`;
      console.log(date);
      let emoji = document.getElementsByClassName("emoji1")[1];
      let emoji2 = document.getElementsByClassName("emoji2")[1];
      let emoji3 = document.getElementsByClassName("emoji3")[1];
      emoji.style.fontWeight="bold";
      emoji2.style.fontWeight="normal";
      emoji3.style.fontWeight="normal";
      Array.from(document.getElementsByClassName("changecolor"));

      alert(Array.findIndex((item)=>item.innerText===nowDate));
      
      //alert(document.getElementsByClassName("changecolor")[2].innerText);

      //document.querySelector(".changecolor").indexOf(nowDate).style.backgroundColor="white";
     // el.querySelector(".changecolor").style.borderRadius="50%";
      //el.querySelector(".changecolor").style.color="black";
      //console.log(nowMonth,nowYear);
    }

    function createTable(dayOfWeek,lastDate){ //달력 내부 만드는 코드
      let table = document.getElementById("calander");
      //table 비우기 처음에 실행되면 이전의 값은 사라져야하니까
      //let tchilds = document.querySelector("#calander>tr:nth-child(n+2)").remove();
      let tablecontent = document.getElementById("calander").innerText="";
      console.log(tablecontent);

      //2차원 배열 선언 arr[6][7]
      var arr = new Array(6);
      let day = 1;
      for(let i=0;i<arr.length;i++){
        arr[i] = new Array(7);
      }
      for(let i=0;i<6;i++){
        if(i==0){ //첫째줄
          if(dayOfWeek==0){
            dayOfWeek=7;
          }
          for(let j=dayOfWeek-1;j<7;j++){
            console.log(dayOfWeek);
            arr[i][j]=day;
            day++;
          }
        }else{ //그 아래줄들
          for(let j=0;j<7;j++){
            if(day==lastDate+1){
              break;
            }else{
              arr[i][j]=day;
              day++;
            }
          }
        }
      }
      console.log(arr);
      //table생성
      for(let i=0;i<6;i++){
        let tr = document.createElement("tr");
        for(let j=0;j<7;j++){
          let td = document.createElement("td");
          if(arr[i][j]!=undefined){
            td.innerHTML=`<span class="changebox">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><br><span class="changecolor">${arr[i][j]}</span>`;
          }
          tr.appendChild(td);
        }
        table.appendChild(tr); 
      }
      return table;
    }

    function before_month(){ //이전 버튼 누르면 이전 달로 
      nowMonth--;
      if(nowMonth<0){
        nowMonth=11;
        nowYear--;
      }
      createDate(nowMonth,nowYear);
      //createTable(dayOfWeek,lastDate); 이거 안써도 왜 table이 생기는 거지..? createDate()에 createTable 넣어놨네..;
      
    }

    function after_month(){ // 다음 버튼 누르면 다음 달로
      nowMonth++;
      if(nowMonth>11){
        nowMonth=0;
        nowYear++;
      }
      createDate(nowMonth,nowYear);
      //createTable(dayOfWeek,lastDate);
    }

    function checkdate(){
      let table = document.getElementById("calander");
      
    }
    //날짜 옆에 이모지 눌렀을 때 글씨 굵기 변하게 하는 코드
    function emoji(){ //처음 눌렀을때 반응 없고 두번째 클릭했을 때부터 변함.
      let e1 = document.getElementsByClassName("emoji1");
      let e2 = document.getElementsByClassName("emoji2");
      let e3 = document.getElementsByClassName("emoji3");
      e1[0].addEventListener("click",function(){
        e1[1].style.fontWeight="bold";
        e2[1].style.fontWeight="normal";
        e3[1].style.fontWeight="normal";
      })
      e1[1].addEventListener("click",function(){
        e1[1].style.fontWeight="bold";
        e2[1].style.fontWeight="normal";
        e3[1].style.fontWeight="normal";
      })
      e2[0].addEventListener("click",function(){
        e1[1].style.fontWeight="normal";
        e2[1].style.fontWeight="bold";
        e3[1].style.fontWeight="normal";
      })
      e2[1].addEventListener("click",function(){
        e1[1].style.fontWeight="normal";
        e2[1].style.fontWeight="bold";
        e3[1].style.fontWeight="normal";
      })
      e3[0].addEventListener("click",function(){
        e1[1].style.fontWeight="normal";
        e2[1].style.fontWeight="normal";
        e3[1].style.fontWeight="bold";
      })
      e3[1].addEventListener("click",function(){
        e1[1].style.fontWeight="normal";
        e2[1].style.fontWeight="normal";
        e3[1].style.fontWeight="bold";
      })
    }
    