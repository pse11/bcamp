const Btn = (props) => {
  //App의 자식 컴포넌트
  //console.log(props);
  return (
    <>
      <button style={{ fontSize: props.size }}>{props.text}</button>
    </>
  );
};

export default Btn;
