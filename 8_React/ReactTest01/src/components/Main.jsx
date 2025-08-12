import "./m.css";
const Main = () => {
  const obj = {
    a: "lcj",
    b: false,
  };
  //return  <>{obj.b ? <div>{obj.a + "-true"}</div> : <div>{obj.a + "-false"}</div>}</>;
  if (obj.b) {
    return (
      <div style={{ backgroundColor: "red", borderBottom: "10px solid blue" }}>
        참
      </div>
    );
  } else {
    return <div className="test">거짓</div>; //클래스명 부여 : className
  }
};

export default Main; //현재 이 코드내의 Main이라는 컴포넌트를 기본으로 하겠다.
