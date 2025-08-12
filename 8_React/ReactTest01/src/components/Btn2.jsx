//const Btn2 = (props) =>{
const Btn2 = ({ text, size = 10 }) => {
  //값이 안넘오는 것은 10으로 size 기본 배정
  //{prop,props} => 구조 분해 할당
  //console.log(props);
  const onClickBtn = () => {
    console.log(text);
    console.log(size);
    console.log(e);
  };
  return (
    <>
      <button onClick={onClickBtn} style={{ fontSize: size }}>
        {text}
      </button>
    </>
  );
};

export default Btn2;
