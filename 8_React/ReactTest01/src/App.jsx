import { useState } from "react";
import "./App.css";
import Footer from "./components/Footer.jsx";

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
  return (
    <>
      <Header />
      <Footer />
    </>
  );
}

export default App;
