let now = new Date();
  let nowMonth= now.getMonth();
  let nowYear= now.getFullYear();
  let dayOfWeek;
  let lastDate;
  let nowDate= now.getDate();
  let firstDate;
    window.onload=function(){ //페이지 로드될때 달력 불러와야됨
      createDate();
     // console.log(firstDate);
      clicktable();
    };
    function clicktable(){
        let tds = document.querySelectorAll("#calander td");
      tds.forEach(function(el,i){
        el.addEventListener('click',(e)=>{
             //클릭한 요소
            //el.getElementsByClassName("changecolor").style.borderRadius="50%";
           
            el.querySelector(".changecolor").style.backgroundColor="white";
            el.querySelector(".changecolor").style.borderRadius="50%";
            el.querySelector(".changecolor").style.color="black";
        })
      })
    }
    function createDate(nowMonth=now.getMonth(),nowYear=now.getFullYear()){
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
      clicktable();
      let date = document.getElementById("date");
      date.textContent=`${nowYear}년 ${nowMonth+1}월`;
      console.log(date);
      //console.log(nowMonth,nowYear);
    }

    function createTable(dayOfWeek,lastDate){
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
             td.innerHTML=`<span>⬜</span><br><span class="changecolor">${arr[i][j]}</span>`;
          }
          tr.appendChild(td);
        }
        table.appendChild(tr); 
      }
      return table;
    }

    function before_month(){
      nowMonth--;
      if(nowMonth<0){
        nowMonth=11;
        nowYear--;
      }
      createDate(nowMonth,nowYear);
      //createTable(dayOfWeek,lastDate); 이거 안써도 왜 table이 생기는 거지..? createDate()에 createTable 넣어놨네..;
      
    }

    function after_month(){
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

    function emoji(){
      let emoji = document
    }
    