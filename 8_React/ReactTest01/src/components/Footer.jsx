function Footer() {
  const name = "lcj";
  const no = 10;
  const obj = { a: 1, b: 2 };
  return (
    <>
      {/*최상위 태그가 두개일 때 빈 태그 <></>로 묶어버린다*/}
      <footer>
        <h1>footer!! {name}</h1>
        <h3>{no + 5}</h3> {/*리터럴이라고 할 수 있는 식은 모두 가능*/}
        <h3>{no + 5 + "ddd"}</h3>
        <h3>{no % 2 == 0 ? "짝수" : "홀수"}</h3>
        <h3>{obj.a + ":" + obj.b}</h3>
        {/*무슨 태그던지 닫아줘야함 <hr/> 또는 <hr></hr> 이렇게 명시해주어야 한다.*/}
      </footer>
      <div>div</div>
    </>
  );
}

//외부에서 사용할 수 있도록 export 설정
export default Footer;
