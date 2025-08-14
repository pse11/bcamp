import Home from "./pages/Home";
import List from "./pages/List";
import Detail from "./pages/Detail";
import Error from "./pages/Error";

import { Routes, Route } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

function App() {
  const navi = useNavigate(); //navi안에 페이지 이동시키는 함수가 들어간다. location.href에서 location객체 사용하는 것과 유사
  function onClickBtn() {
    //클릭 시 페이지 이동시키는 함수 활용
    navi("/list");
  }
  return (
    <>
      <button onClick={onClickBtn}>클릭</button>
      <a href="/list">리스트</a>
      {/*a태그는 잘 이동하지만 순간적으로 새로고침을 함*/}
      <div>
        <Link to={"/home"}>Home</Link> &nbsp;
        <Link to={"/list"}>List</Link>&nbsp;
        <Link to={"/detail/2"}>Detail</Link>
      </div>
      <Routes>
        <Route path="/" element={<Home />} />
        {/*이런 요청이 들어오면 이걸 보여줘라. path="/" => 기본 페이지 요청 시 */}
        <Route path="/list" element={<List />} />
        <Route path="/detail/:id" element={<Detail />} />
        {/*형식만 갖춰지면 값 상관없이 detail 페이지 랜더링*/}
        <Route path="*" element={<Error />} />
        {/* path="*" : * -> 와일드카드 */}
        {/* <Routes>안에는 <Route>만 넣어야함.  */}
      </Routes>
    </>
  );
}

export default App;
