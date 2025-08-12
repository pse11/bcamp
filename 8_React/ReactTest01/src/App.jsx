import { useState } from "react";
import "./App.css";
import Footer from "./components/Footer.jsx";
import Main from "./components/Main"; //컴포넌트 import할 때는 .jsx생략가능
import Btn from "./components/Btn.jsx";
import Btn2 from "./components/Btn2.jsx";
//컴퍼넌트의 함수 이름은 첫글자 대문자
//html 을 리턴하는 함수 => 컴포넌트

//function Header(){}
//화살표 함수 버전
const Header = () => {
  return (
    <header>
      <h1>Header..</h1>
    </header>
  );
};

function App() {
  const btnData = {
    text: "작성완료",
    size: 50,
  };
  return (
    <>
      <Header />
      <Main />
      <Footer />
      <hr></hr>
      <Btn text={"확인"} size={30} a={1} b={2} c={3} />
      <Btn text={"완료"} />
      <hr></hr>
      {/*<Btn2 obj={btnData} /> 자식인 Btn2에 obj전달 */}
      <Btn2 {...btnData} />
      {/* ... => 스프레드 연산자 */}
      <Btn2 text={"취소"}>
        <div>Btn2의 자식 태그</div>
        <Main></Main>
      </Btn2>
    </>
  );
}

export default App;
