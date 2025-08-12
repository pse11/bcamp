import { useState } from "react";
//State : 변수처럼 활용할 수 있음. 특정 컴포넌트의 상태값
//1. useState import

const Body = ({ st, test }) => {
  return (
    <div>
      <h1>
        Body입니다. state값 : {st}, test값 : {test}
      </h1>
    </div>
  );
};
function App2() {
  //2. state 생성
  const [state, setState] = useState(0);

  const [test, setTest] = useState("TEST");

  let cnt = 0;
  return (
    <>
      <h1>state:{state}</h1>
      <h1>var:{cnt}</h1>
      <Body st={state} test={test} />
      <hr></hr>
      <button
        onClick={() => {
          setState(state + 1);
          cnt += 1;
          console.log("cnt: " + cnt);
          //해당 컴포넌트에서 state값이 변하게 되면 그걸 감지하고 해당 컴포넌트를 새로고침하게 된다(랜더링).
          //=> state값 변화 감지되면 리랜더링
          //  그로 인해 state값이 바뀌고 상태값 유지. 반대로 일반적인 스크립트 변수의 경우 새로고침하게 되면 다시 초기화하게 된다.
        }}
      >
        클릭
      </button>
    </>
  );
}

export default App2;
