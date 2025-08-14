//parameter 받기
import { useParams } from "react-router-dom"; // 파라미터 값 받아오는 것
const Detail = () => {
  const params = useParams();
  console.log(params);
  //http://localhost:5173/detail/kim => params에 {id: 'kim'}로 받아진다
  return <h1>{params.id}의 Detail Page</h1>;
};

export default Detail;
